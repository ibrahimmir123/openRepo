package com.capgemini.training.manjeet.dto;

import java.time.LocalDateTime;

/**
 * @Author Manjeet Kumar
 *  01-Aug-2025
 */
public class ApiResponse<T> {
	
	private LocalDateTime timestamp;
	private int status;
	private String message;
	private T data;
	/**
	 * 
	 */
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param timestamp
	 * @param status
	 * @param message
	 * @param data
	 */
	public ApiResponse(int status, String message, T data) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ApiResponse [timestamp=" + timestamp + ", status=" + status + ", message=" + message + ", data=" + data
				+ "]";
	}
	
	

}

