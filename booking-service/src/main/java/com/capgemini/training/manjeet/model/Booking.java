package com.capgemini.training.manjeet.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

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
	 * 
	 */
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param bookingId
	 * @param vehicleId
	 * @param customerId
	 * @param routeId
	 * @param bookingDate
	 * @param journeyDate
	 * @param boardingPoint
	 * @param dropPoint
	 * @param fare
	 * @param status
	 */
	public Booking(Long bookingId, Long vehicleId, Long customerId, Long routeId, LocalDate bookingDate,
			LocalDate journeyDate, String boardingPoint, String dropPoint, double fare, String status) {
		super();
		this.bookingId = bookingId;
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.routeId = routeId;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.boardingPoint = boardingPoint;
		this.dropPoint = dropPoint;
		this.fare = fare;
		this.status = status;
	}
	/**
	 * @return the bookingId
	 */
	public Long getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
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
	public int hashCode() {
		return Objects.hash(boardingPoint, bookingDate, bookingId, customerId, dropPoint, fare, journeyDate, routeId,
				status, vehicleId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(boardingPoint, other.boardingPoint) && Objects.equals(bookingDate, other.bookingDate)
				&& Objects.equals(bookingId, other.bookingId) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(dropPoint, other.dropPoint)
				&& Double.doubleToLongBits(fare) == Double.doubleToLongBits(other.fare)
				&& Objects.equals(journeyDate, other.journeyDate) && Objects.equals(routeId, other.routeId)
				&& Objects.equals(status, other.status) && Objects.equals(vehicleId, other.vehicleId);
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", vehicleId=" + vehicleId + ", customerId=" + customerId
				+ ", routeId=" + routeId + ", bookingDate=" + bookingDate + ", journeyDate=" + journeyDate
				+ ", boardingPoint=" + boardingPoint + ", dropPoint=" + dropPoint + ", fare=" + fare + ", status="
				+ status + "]";
	}

    
}
