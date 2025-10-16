package com.capgemini.training.manjeet.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class CustomAuthenticationFilter implements GlobalFilter, Ordered {

	private final WebClient webClient;

    public CustomAuthenticationFilter(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8088").build(); 
        // Replace with your actual Auth Service URL
    }


@Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        
	String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        	String token = authHeader.substring(7);

            System.out.println("Extracted token : " + token);


            return webClient.post()
                .uri("/auth/validate")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .retrieve()
                .onStatus(status -> status.value() >= 400, clientResponse ->
                clientResponse.bodyToMono(String.class)
                    .defaultIfEmpty("Invalid token")
                    .flatMap(errorBody -> Mono.error(new RuntimeException("Token validation failed: " + errorBody)))
            )
            .toBodilessEntity()
            .flatMap(response -> chain.filter(exchange))
            .onErrorResume(e -> {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            });

    }



@Override
public int getOrder() {
	return -1;
}

}
