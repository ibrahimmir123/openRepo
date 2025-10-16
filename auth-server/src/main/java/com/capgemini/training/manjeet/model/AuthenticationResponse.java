package com.capgemini.training.manjeet.model;

/**
 * @Author Manjeet Kumar
 *  30-Jul-2025
 */
public class AuthenticationResponse {

	private final String token;



	/**
	 * @param token
	 */
	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}



	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	
	
}

