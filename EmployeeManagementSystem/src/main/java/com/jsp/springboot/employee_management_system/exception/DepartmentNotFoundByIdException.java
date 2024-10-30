package com.jsp.springboot.employee_management_system.exception;

public class DepartmentNotFoundByIdException extends RuntimeException{
	private String message;

	public DepartmentNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
