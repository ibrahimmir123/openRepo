package com.capgemini.training.manjeet.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capgemini.training.manjeet.dto.ApiResponse;

/**
 * @Author Manjeet Kumar 01-Aug-2025
 */
public class ResponseBuilder {

	public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {
		return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), message, data), HttpStatus.OK);
	}

	public static <T> ResponseEntity<ApiResponse<T>> created(T data, String message) {
		return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED.value(), message, data), HttpStatus.CREATED);
	}

	public static <T> ResponseEntity<ApiResponse<T>> error(HttpStatus status, String message) {
		return new ResponseEntity<>(new ApiResponse<>(status.value(), message, null), status);
	}

}
