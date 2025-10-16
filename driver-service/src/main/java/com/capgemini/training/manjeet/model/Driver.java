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
@Table(name = "tb_driver")
public class Driver {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    private String name;
    private String address;
    private String contactNo;
    private String licenseNo;
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
	 * @param address
	 * @param contactNo
	 * @param licenseNo
	 */
	public Driver(Long driverId, String name, String address, String contactNo, String licenseNo) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.licenseNo = licenseNo;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", name=" + name + ", address=" + address + ", contactNo=" + contactNo
				+ ", licenseNo=" + licenseNo + "]";
	}
    
    

}

