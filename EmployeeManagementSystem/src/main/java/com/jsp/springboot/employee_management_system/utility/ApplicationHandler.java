package com.jsp.springboot.employee_management_system.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.employee_management_system.exception.EmployeeNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> employeeNotFoundByException(EmployeeNotFoundByIdException ee){
		
		return new ResponseEntity<ErrorStructure<String>>(createErrorStructure
				(HttpStatus.NOT_FOUND.value(),"Employee Not Found By Id",ee.getMessage()), HttpStatus.NOT_FOUND);
	}

	private ErrorStructure<String> createErrorStructure(int value, String string, String data) {
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setData(data);
		errorStructure.setMessage(string);
		errorStructure.setStatusCode(value);
		return errorStructure;
	}
}
