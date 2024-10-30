package com.jsp.springboot.employee_management_system.exception;

public class EmployeeNotFoundByDepartmentIdException extends RuntimeException {
	private String message;

	public EmployeeNotFoundByDepartmentIdException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	
}
