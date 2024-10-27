package com.jsp.springboot.mobile_management_system.exception;

public class MobileNotFoundByOperatingSystem extends RuntimeException {
	private String message;

	public MobileNotFoundByOperatingSystem(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
