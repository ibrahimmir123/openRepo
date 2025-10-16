package com.capgemini.training.manjeet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.capgemini.training.manjeet.model.Route;
import com.capgemini.training.manjeet.repository.RouteRepository;

/**
 * @Author Manjeet Kumar 25-Jul-2025
 */

@Service
public class RouteService {

	@Autowired
	private RouteRepository routeRepository;

	public Route addRouteDetails(Route route) {
		return routeRepository.save(route);

	}

	public Optional<List<Route>> getAllRoutesDetails() {
		List<Route> routes = routeRepository.findAll();
		return routes.isEmpty() ? Optional.empty() : Optional.of(routes);
	}

	public Optional<Route> getRouteDetailsByRouteId(Long routeId) {
		return routeRepository.findById(routeId);
	}

	public Route updateRouteDetails(Long routeId, Route route) {
		Route routeDetails = routeRepository.findById(routeId)
				.orElseThrow(() -> new RuntimeException("Route Details not found.."));
		routeDetails.setSource(route.getSource());
		routeDetails.setDestination(route.getDestination());
		routeDetails.setDistance(route.getDistance());
		routeDetails.setDuration(route.getDuration());
		return routeRepository.save(route);

	}

	public void deleteRouteDetails(Long routeId) {
		routeRepository.deleteById(routeId);
	}

	public Optional<List<Route>> searchRoutesDetails(String source, String destination, Pageable pageable) {

		if (source == null || destination == null) {
			return Optional.empty(); 
		}
		List<Route> routes;
		if (pageable != null) {
			routes = routeRepository.findBySourceContainingIgnoreCaseAndDestinationContainingIgnoreCase(source,
					destination, pageable);
		} else {
			routes = routeRepository.searchRoutes(source, destination);
		}

		return routes.isEmpty() ? Optional.empty() : Optional.of(routes);
	}

}
