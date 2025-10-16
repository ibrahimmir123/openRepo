package com.capgemini.training.manjeet.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @Author Manjeet Kumar 
 * 05-sept-2025
 */

@Entity
@Table(name = "tb_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	private String name;
	private LocalDate dob;
	private String gender;
	private String address;
	private String mobileNo;
	@Column(unique = true)
	private String email;
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param customerId
	 * @param name
	 * @param dob
	 * @param gender
	 * @param address
	 * @param mobileNo
	 * @param email
	 */
	public Customer(Long customerId, String name, LocalDate dob, String gender, String address, String mobileNo,
			String email) {
		super();
		this.customerId=customerId;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
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
	public int hashCode() {
		return Objects.hash(address, customerId, dob, email, gender, mobileNo, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", dob=" + dob + ", gender=" + gender
				+ ", address=" + address + ", mobileNo=" + mobileNo + ", email=" + email + "]";
	}

	
}
