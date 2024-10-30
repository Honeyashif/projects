package com.jsp.springboot.employee_management_system.exception;

public class EmployeeNotFoundByIdException extends RuntimeException{
	private String message;

	public EmployeeNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
