package com.capgemini.training.manjeet.model;

/**
 * @Author Manjeet Kumar 30-Jul-2025
 */
public class LoginRequest {

	private String useremail;
	private String password;
	
	/**
	 * @param useremail
	 * @param password
	 */
	public LoginRequest(String useremail, String password) {
		super();
		this.useremail = useremail;
		this.password = password;
	}
	/**
	 * @return the useremail
	 */
	public String getUseremail() {
		return useremail;
	}
	/**
	 * @param useremail the useremail to set
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequest [useremail=" + useremail + ", password=" + password + "]";
	}
	
	
	
	
}
