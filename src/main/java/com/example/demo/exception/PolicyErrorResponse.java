package com.example.demo.exception;

import java.util.List;

public class PolicyErrorResponse {
	
	private String message;
	private List<String> details;
	private int status;

	public PolicyErrorResponse(String message, List<String> details, int status) {
		super();
		this.message = message;
		this.details = details;
		this.status = status;
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
		
	
	
	

	
	

}
