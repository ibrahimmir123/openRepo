package com.capgemini.training.manjeet.dto;

/**
 * @Author Manjeet Kumar 02-Sept-2025
 */
public class CustomerResponseDTO {

	private Long customerId;
	private String name;
	private String email;
	/**
	 * 
	 */
	public CustomerResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param customerId
	 * @param name
	 * @param email
	 */
	public CustomerResponseDTO(Long customerId, String name, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
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
		return "CustomerResponseDTO [customerId=" + customerId + ", name=" + name + ", email=" + email + "]";
	}

	
}
