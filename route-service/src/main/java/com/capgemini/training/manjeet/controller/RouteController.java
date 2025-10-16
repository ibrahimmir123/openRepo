package com.capgemini.training.manjeet.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.manjeet.dto.ApiResponse;
import com.capgemini.training.manjeet.dto.RouteRequestDTO;
import com.capgemini.training.manjeet.dto.RouteResponseDTO;
import com.capgemini.training.manjeet.mapper.RouteMapper;
import com.capgemini.training.manjeet.model.Route;
import com.capgemini.training.manjeet.service.RouteService;
import com.capgemini.training.manjeet.util.ResponseBuilder;

/**
 * @Author Manjeet Kumar 03-Sept-2025
 */

@RestController
@RequestMapping("/api/v1/routes")
public class RouteController {

	private static final Logger logger = LoggerFactory.getLogger(RouteController.class);

	@Autowired
	private RouteService routeService;

	@PostMapping
	public ResponseEntity<ApiResponse<RouteResponseDTO>> addRouteDetails(@RequestBody RouteRequestDTO requestDTO) {
		logger.info("Creating new Route..");
		try {
			Route routeDetails = routeService.addRouteDetails(RouteMapper.convertToEntity(requestDTO));
			return ResponseBuilder.created(RouteMapper.convertToResponseDTO(routeDetails),
					"Route Created Successfully !!");
		} catch (RuntimeException e) {
			logger.error("Route creation fail", e);
			return ResponseBuilder.error(HttpStatus.INTERNAL_SERVER_ERROR, "Getting Error : " + e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<RouteResponseDTO>>> getAllRoutesDetails() {
		logger.info("Fetching all Route details...");
		return routeService.getAllRoutesDetails()
				.map(allRoutes -> ResponseBuilder.success(RouteMapper.convertToListOfResponseDTO(allRoutes),
						"Route Details Fetch Successfully !!"))
				.orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Route details not found !!"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<RouteResponseDTO>> getRouteDetailsByRouteId(@PathVariable Long routeId) {
		logger.info("Fetching Route details by routeId...");
		return routeService.getRouteDetailsByRouteId(routeId)
				.map(route -> ResponseBuilder.success(RouteMapper.convertToResponseDTO(route),
						"Route Details Fetch Successfully !!"))
				.orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Route not found with routeId: " + routeId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<RouteResponseDTO>> updateRoute(@PathVariable Long routeId,
			@RequestBody RouteRequestDTO requestDTO) {
		logger.info("Updation Route details..");
		try {
			Route updateRouteDetails = routeService.updateRouteDetails(routeId,
					RouteMapper.convertToEntity(requestDTO));
			return ResponseBuilder.success(RouteMapper.convertToResponseDTO(updateRouteDetails),
					"Route Details updated Successfully !!");
		} catch (RuntimeException e) {
			logger.error("Route details updation fail..", e);
			return ResponseBuilder.error(HttpStatus.NOT_FOUND, "Getting Error : " + e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRouteDetails(@PathVariable Long routeId) {
		routeService.deleteRouteDetails(routeId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/search")
	public ResponseEntity<ApiResponse<List<RouteResponseDTO>>> searchRoutesDetails(
			@RequestParam String source, 
			@RequestParam String destination,

			@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
		Pageable pageable=PageRequest.of(page, size);
		return routeService.searchRoutesDetails(source, destination,pageable)
				.map(allRoutes -> ResponseBuilder.success(RouteMapper.convertToListOfResponseDTO(allRoutes),
					"Route Details find Successfully !!"))
			.orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Route details not found !!"));
	}

}
