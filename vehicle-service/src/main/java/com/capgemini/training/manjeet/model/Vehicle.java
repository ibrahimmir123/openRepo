package com.capgemini.training.manjeet.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @Author Manjeet Kumar 25-Jul-2025
 */

@Entity
@Table(name = "tb_vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vehicleId;
	private String vehicleNo;
	private String vehicleName;
	private int seatingCapacity;
	private String vehicleType;
	private double farePerKm;

	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private List<Driver> drivers;

	/**
	 * 
	 */
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param vehicleId
	 * @param vehicleNo
	 * @param vehicleName
	 * @param seatingCapacity
	 * @param vehicleType
	 * @param farePerKm
	 * @param drivers
	 */
	public Vehicle(Long vehicleId, String vehicleNo, String vehicleName, int seatingCapacity, String vehicleType,
			double farePerKm, List<Driver> drivers) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNo = vehicleNo;
		this.vehicleName = vehicleName;
		this.seatingCapacity = seatingCapacity;
		this.vehicleType = vehicleType;
		this.farePerKm = farePerKm;
		this.drivers = drivers;
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
	 * @return the vehicleNo
	 */
	public String getVehicleNo() {
		return vehicleNo;
	}

	/**
	 * @param vehicleNo the vehicleNo to set
	 */
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	/**
	 * @return the vehicleName
	 */
	public String getVehicleName() {
		return vehicleName;
	}

	/**
	 * @param vehicleName the vehicleName to set
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	/**
	 * @return the seatingCapacity
	 */
	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	/**
	 * @param seatingCapacity the seatingCapacity to set
	 */
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the farePerKm
	 */
	public double getFarePerKm() {
		return farePerKm;
	}

	/**
	 * @param farePerKm the farePerKm to set
	 */
	public void setFarePerKm(double farePerKm) {
		this.farePerKm = farePerKm;
	}

	/**
	 * @return the drivers
	 */
	public List<Driver> getDrivers() {
		return drivers;
	}

	/**
	 * @param drivers the drivers to set
	 */
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleNo=" + vehicleNo + ", vehicleName=" + vehicleName
				+ ", seatingCapacity=" + seatingCapacity + ", vehicleType=" + vehicleType + ", farePerKm=" + farePerKm
				+ ", drivers=" + drivers + "]";
	}

	
	
	}
