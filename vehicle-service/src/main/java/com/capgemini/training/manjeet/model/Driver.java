package com.capgemini.training.manjeet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @Author Manjeet Kumar
 *  04-Sept-2025
 */

@Entity
@Table(name = "tb_driver")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    private String name;
    private String licenseNo;

    @ManyToOne
    @JoinColumn(name = "vehicle_no", nullable = false)
    private Vehicle vehicle;

	/**
	 * 
	 */
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param driverId
	 * @param name
	 * @param licenseNo
	 * @param vehicle
	 */
	public Driver(Long driverId, String name, String licenseNo, Vehicle vehicle) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.licenseNo = licenseNo;
		this.vehicle = vehicle;
	}

	/**
	 * @return the driverId
	 */
	public Long getDriverId() {
		return driverId;
	}

	/**
	 * @param driverId the driverId to set
	 */
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the licenseNo
	 */
	public String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * @param licenseNo the licenseNo to set
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", name=" + name + ", licenseNo=" + licenseNo + ", vehicle=" + vehicle
				+ "]";
	}
    
    

}

