package com.capgemini.training.manjeet.dto;

/**
 * @Author Manjeet Kumar
 *  03-Sept-2025
 */
public class DriverResponseDTO {

    private Long driverId;
    private String name;
    private String contactNo;
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
	 * @param contactNo
	 */
	public DriverResponseDTO(Long driverId, String name, String contactNo) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.contactNo = contactNo;
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
	@Override
	public String toString() {
		return "DriverResponseDTO [driverId=" + driverId + ", name=" + name + ", contactNo=" + contactNo + "]";
	}
    
    
}

