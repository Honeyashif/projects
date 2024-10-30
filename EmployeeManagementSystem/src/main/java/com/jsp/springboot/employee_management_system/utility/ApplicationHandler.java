package com.jsp.springboot.employee_management_system.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.employee_management_system.exception.DepartmentNotFoundByIdException;
import com.jsp.springboot.employee_management_system.exception.EmployeeNotFoundByIdException;
import com.jsp.springboot.employee_management_system.exception.EmployeeNotFoundByJobException;

@RestControllerAdvice
public class ApplicationHandler {

	private ErrorStructure<String> createErrorStructure(int value, String string, String data) {
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setData(data);
		errorStructure.setMessage(string);
		errorStructure.setStatusCode(value);
		return errorStructure;
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> employeeNotFoundByException(EmployeeNotFoundByIdException ee){
		
		return new ResponseEntity<ErrorStructure<String>>(createErrorStructure
				(HttpStatus.NOT_FOUND.value(),"Employee Not Found By Id",ee.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> departmentNotFoundByIdException(DepartmentNotFoundByIdException de){
		return new ResponseEntity<ErrorStructure<String>>(createErrorStructure
				(HttpStatus.NOT_FOUND.value(), "Department Not Found for that Specific Id", de.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> employeeNotFoundByJobException(EmployeeNotFoundByJobException ee){
		return new ResponseEntity<ErrorStructure<String>>(createErrorStructure
				(HttpStatus.NOT_FOUND.value(), "Employee Not Found for that Specified Job", ee.getMessage()), HttpStatus.NOT_FOUND);
	}
	
}
