package com.capgemini.training.manjeet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.training.manjeet.dto.ApiResponse;
import com.capgemini.training.manjeet.util.ResponseBuilder;

/**
 * @Author Manjeet Kumar 01-Aug-2025
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<ApiResponse<Object>> handleException(Exception ex) {
		ex.printStackTrace();
		return ResponseBuilder.error(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong : " + ex.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<Object>> handleValidationException(MethodArgumentNotValidException ex) {
		String msg = ex.getBindingResult().getFieldErrors().stream()
				.map(err -> err.getField() + " " + err.getDefaultMessage()).findFirst().orElse("Validation Error !!");
		return ResponseBuilder.error(HttpStatus.BAD_REQUEST, msg);
	}
	

	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handleRuntimeException(RuntimeException ex) {
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST,"Runtime Error: " + ex.getMessage());
    }


}
