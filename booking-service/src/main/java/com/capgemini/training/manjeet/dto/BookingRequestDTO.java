package com.capgemini.training.manjeet.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;

/**
 * @Author Manjeet Kumar 28-Jul-2025
 */
@Data
@Getter
public class BookingRequestDTO {

	private Long vehicleId;
	private Long customerId;
	private Long routeId;
	private LocalDate bookingDate;
	private LocalDate journeyDate;
	private String boardingPoint;
	private String dropPoint;
	private double fare;
	private String status;

	/**
	 * @return the vehicleId
	 */
	public Long getVehicleId() {
		return vehicleId;
	}

	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	 * @return the bookingDate
	 */
	public LocalDate getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return the journeyDate
	 */
	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	/**
	 * @param journeyDate the journeyDate to set
	 */
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	/**
	 * @return the boardingPoint
	 */
	public String getBoardingPoint() {
		return boardingPoint;
	}

	/**
	 * @param boardingPoint the boardingPoint to set
	 */
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	/**
	 * @return the dropPoint
	 */
	public String getDropPoint() {
		return dropPoint;
	}

	/**
	 * @param dropPoint the dropPoint to set
	 */
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}

	/**
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(double fare) {
		this.fare = fare;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingRequestDTO [vehicleId=" + vehicleId + ", customerId=" + customerId + ", routeId=" + routeId
				+ ", bookingDate=" + bookingDate + ", journeyDate=" + journeyDate + ", boardingPoint=" + boardingPoint
				+ ", dropPoint=" + dropPoint + ", fare=" + fare + ", status=" + status + "]";
	}

	
}
