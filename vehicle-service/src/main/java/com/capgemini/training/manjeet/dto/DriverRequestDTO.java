package com.capgemini.training.manjeet.dto;

/**
 * @Author Manjeet Kumar
 *  05-Sept-2025
 */
public class DriverRequestDTO {


    private String name;
    private String address;
    private String contactNo;
    private String licenseNo;
	/**
	 * 
	 */
	public DriverRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param address
	 * @param contactNo
	 * @param licenseNo
	 */
	public DriverRequestDTO(String name, String address, String contactNo, String licenseNo) {
		super();
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.licenseNo = licenseNo;
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
    
    
}



