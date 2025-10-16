package com.capgemini.training.manjeet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.training.manjeet.config.SecurityConfig;
import com.capgemini.training.manjeet.model.LoginRequest;
import com.capgemini.training.manjeet.model.SignupRequest;
import com.capgemini.training.manjeet.model.TokenVlidationResponse;
import com.capgemini.training.manjeet.model.User;
import com.capgemini.training.manjeet.repository.AuthRepository;
import com.capgemini.training.manjeet.util.JwtUtils;

/**
 * @Author Manjeet Kumar 30-Jul-2025
 */

@Service
public class AuthService {

	@Autowired
	private JwtUtils jwtUtil;

	@Autowired
	private AuthRepository authRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	AuthService(SecurityConfig securityConfig) {
	}

	public String registerUser(SignupRequest signupRequest) {
		if (authRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
			throw new RuntimeException("User already exists with email :" + signupRequest.getEmail());
		}
		User user = new User();
		user.setName(signupRequest.getName());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
		user.setRole("admin");

		authRepository.save(user);
		return "User Registered successfully!!";
	}

	/**
	 * @param authenticationRequest
	 * @return
	 */
	public String userLogin(LoginRequest loginRequest) {
		System.out.println(loginRequest.getUseremail());
		System.out.println();
		String token = null;
		if (authRepository.findByEmail(loginRequest.getUseremail()).isPresent()) {
			Optional<User> passwordByName = authRepository.findPasswordByEmail(loginRequest.getUseremail());
			System.out.println("Login password: " + loginRequest.getPassword());
			System.out.println("database password: " + passwordByName.get().getPassword());
			if (!passwordEncoder.matches(loginRequest.getPassword(), passwordByName.get().getPassword())) {

				throw new RuntimeException("Invalid Password !!");
			} else {
				token = jwtUtil.generateToken(loginRequest.getUseremail());
			}
		} else {
			throw new RuntimeException("Invalid Email !!");
		}
		return token;
	}

	/**
	 * @param token
	 * @return 
	 */
	public TokenVlidationResponse validateToken(String token) {
		String jwt = token.startsWith("Bearer ") ? token.substring(7) : token;
		String username=null;
	boolean isValid = jwtUtil.validateToken(jwt);
	if(isValid) {
		 username = jwtUtil.extractUsername(jwt);
	}else {
		return new TokenVlidationResponse(isValid,"Invalid token");
	}
	return new TokenVlidationResponse(isValid,username);

}
}
