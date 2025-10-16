package com.capgemini.training.manjeet.dto;

import java.time.LocalDate;

/**
 * @Author Manjeet Kumar 02-Sept-2025
 */
public class CustomerRequestDTO {

	private String name;
	private LocalDate dob;
	private String gender;
	private String address;
	private String mobileNo;
	private String email;
	/**
	 * 
	 */
	public CustomerRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param dob
	 * @param gender
	 * @param address
	 * @param mobileNo
	 * @param email
	 */
	public CustomerRequestDTO(String name, LocalDate dob, String gender, String address, String mobileNo,
			String email) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
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
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerRequestDTO [name=" + name + ", dob=" + dob + ", gender=" + gender + ", address=" + address
				+ ", mobileNo=" + mobileNo + ", email=" + email + "]";
	}

	
}
