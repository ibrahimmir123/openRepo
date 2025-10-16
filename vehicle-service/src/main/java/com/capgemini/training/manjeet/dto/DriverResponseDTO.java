package com.capgemini.training.manjeet.dto;

/**
 * @Author Manjeet Kumar 05-Sept-2025
 */
public class DriverResponseDTO {

	private Long driverId;
	private String name;
	private String licenseNo;
	/**
	 * 
	 */
	public DriverResponseDTO() {
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
	/**
	 * @param driverId
	 * @param name
	 * @param licenseNo
	 */
	public DriverResponseDTO(Long driverId, String name, String licenseNo) {
		super();
		this.driverId = driverId;
		this.name = name;
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
		return "DriverResponseDTO [driverId=" + driverId + ", name=" + name + ", licenseNo=" + licenseNo + "]";
	}
	
}
