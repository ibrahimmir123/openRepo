package com.capgemini.training.manjeet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @Author Manjeet Kumar
 *  25-Jul-2025
 */

@Entity
@Table(name = "tb_route")
public class Route {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    private String source;
    private String destination;
    private double distance; // in kilometers
    private String duration;
	/**
	 * 
	 */
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param routeId
	 * @param source
	 * @param destination
	 * @param distance
	 * @param duration
	 */
	public Route(Long routeId, String source, String destination, double distance, String duration) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
	}
	/**
	 * @return the routeId
	 */
	public Long getRouteId() {
		return routeId;
	}
	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", distance="
				+ distance + ", duration=" + duration + "]";
	} 
    
    

}

