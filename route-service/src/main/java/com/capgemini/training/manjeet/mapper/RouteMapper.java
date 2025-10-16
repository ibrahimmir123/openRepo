package com.capgemini.training.manjeet.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.training.manjeet.dto.RouteRequestDTO;
import com.capgemini.training.manjeet.dto.RouteResponseDTO;
import com.capgemini.training.manjeet.model.Route;



/**
 * @Author Manjeet Kumar
 *  02-Sept-2025
 */
public class RouteMapper {

	public static List<RouteResponseDTO> convertToListOfResponseDTO(List<Route> routes) {
		return routes.stream()
		.map(route-> new RouteResponseDTO(route.getRouteId(),route.getSource(),
				route.getDestination(),route.getDistance(),route.getDuration()
			)).collect(Collectors.toList());
	}
	
	public static RouteResponseDTO convertToResponseDTO(Route route) {
		RouteResponseDTO routeResponseDTO =new RouteResponseDTO();
		routeResponseDTO.setRouteId(route.getRouteId());
		routeResponseDTO.setSource(route.getSource());
		routeResponseDTO.setDestination(route.getDestination());
		routeResponseDTO.setDistance(route.getDistance());
		routeResponseDTO.setDuration(route.getDuration());
		return routeResponseDTO;
		
	}
	
	public static Route convertToEntity(RouteRequestDTO dto) {
		Route route=new Route();
		route.setSource(dto.source);
		route.setDestination(dto.destination);
		route.setDistance(dto.distance);
		route.setDuration(dto.duration);
		return route;
	}
}


