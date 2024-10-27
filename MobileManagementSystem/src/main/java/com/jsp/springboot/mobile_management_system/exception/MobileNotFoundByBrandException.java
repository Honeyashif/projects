package com.jsp.springboot.mobile_management_system.exception;

public class MobileNotFoundByBrandException extends RuntimeException {
	private String message;

	public MobileNotFoundByBrandException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
