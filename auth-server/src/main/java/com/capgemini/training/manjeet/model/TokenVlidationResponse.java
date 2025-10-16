package com.capgemini.training.manjeet.model;

/**
 * @Author Manjeet Kumar
 *  31-Jul-2025
 */
public class TokenVlidationResponse {

	private boolean valid;
	private String username;
	/**
	 * 
	 */
	public TokenVlidationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param valid
	 * @param username
	 */
	public TokenVlidationResponse(boolean valid, String username) {
		super();
		this.valid = valid;
		this.username = username;
	}
	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "TokenVlidationResponse [valid=" + valid + ", username=" + username + "]";
	}
	
	
}

