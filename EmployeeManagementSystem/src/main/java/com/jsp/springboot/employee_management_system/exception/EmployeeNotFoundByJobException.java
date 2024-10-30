package com.jsp.springboot.employee_management_system.exception;

public class EmployeeNotFoundByJobException extends RuntimeException {
	private String message;

	public EmployeeNotFoundByJobException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
