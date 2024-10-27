package com.jsp.springboot.mobile_management_system.exception;

public class MobileNotFoundBetweenPrice extends RuntimeException {
	private String message;

	public MobileNotFoundBetweenPrice(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	
}
