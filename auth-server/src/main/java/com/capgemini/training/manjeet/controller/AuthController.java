package com.capgemini.training.manjeet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.manjeet.model.AuthenticationResponse;
import com.capgemini.training.manjeet.model.LoginRequest;
import com.capgemini.training.manjeet.model.SignupRequest;
import com.capgemini.training.manjeet.model.TokenVlidationResponse;
import com.capgemini.training.manjeet.service.AuthService;

/**
 * @Author Manjeet Kumar 30-Jul-2025
 */

@RestController
@RequestMapping("/auth/")
public class AuthController {

	private static final Logger logger=LoggerFactory.getLogger(AuthController.class);
	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody LoginRequest loginRequest) {
		logger.info("user login..");
		String token = authService.userLogin(loginRequest);
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
		System.out.println(signupRequest.toString());
		String registerUser2 = authService.registerUser(signupRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(registerUser2);
	}

	@PostMapping("/validate")
	public ResponseEntity<TokenVlidationResponse> validateToken(@RequestHeader("Authorization") String token) {
		System.out.println("in to the validate token method...");
		TokenVlidationResponse isTokenValid = authService.validateToken(token);
		if (isTokenValid.isValid() == false) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(isTokenValid);
		}
		return ResponseEntity.status(HttpStatus.OK).body(isTokenValid);
	}
}
