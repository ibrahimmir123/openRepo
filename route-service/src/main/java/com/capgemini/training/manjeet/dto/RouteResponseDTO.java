package com.capgemini.training.manjeet.dto;

/**
 * @Author Manjeet Kumar
 *  02-Sept-2025
 */
public class RouteResponseDTO {

	 	public Long routeId;
	    public String source;
	    public String destination;
	    public double distance;
	    public String duration;
		/**
		 * 
		 */
		public RouteResponseDTO() {
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
		public RouteResponseDTO(Long routeId, String source, String destination, double distance, String duration) {
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
			return "RouteResponseDTO [routeId=" + routeId + ", source=" + source + ", destination=" + destination
					+ ", distance=" + distance + ", duration=" + duration + "]";
		}
	    
	    
	    
}

