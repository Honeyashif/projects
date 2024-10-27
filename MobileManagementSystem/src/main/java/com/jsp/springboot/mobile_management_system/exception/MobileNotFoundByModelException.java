package com.jsp.springboot.mobile_management_system.exception;

public class MobileNotFoundByModelException extends RuntimeException {
	private String message;

	public MobileNotFoundByModelException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
