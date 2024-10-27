package com.jsp.springboot.mobile_management_system.exception;

public class MobileNotFoundByIdException extends RuntimeException{

	private String message;

	public MobileNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
