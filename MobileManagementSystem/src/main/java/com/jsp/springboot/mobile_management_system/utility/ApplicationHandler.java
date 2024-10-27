package com.jsp.springboot.mobile_management_system.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundBetweenPrice;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundByBrandException;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundByIdException;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundByModelException;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundByOperatingSystem;

@RestControllerAdvice
public class ApplicationHandler {
	
	private ResponseEntity<ErrorStructure<String>> createErrorStructure(int statusCode,String data,String message){
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setStatusCode(statusCode);
		errorStructure.setData(data);
		errorStructure.setMessage(message);
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> mobileNotFoundByIdException(MobileNotFoundByIdException me){
		
		return createErrorStructure(HttpStatus.NOT_FOUND.value(), me.getMessage(), "Mobile Details Are Not Present in Database for that Id");
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> mobileNotFoundBetweenPrice(MobileNotFoundBetweenPrice me){
		
		return createErrorStructure(HttpStatus.NOT_FOUND.value(), me.getMessage(), "Mobile Details are not Present in between these price");
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> mobileNotFoundByOs(MobileNotFoundByOperatingSystem me){
		return createErrorStructure(HttpStatus.NOT_FOUND.value(), me.getMessage(), "Mobile Details are not Present in between these price");
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> mobilNotFoundByBrand(MobileNotFoundByBrandException me){
		return createErrorStructure(HttpStatus.NOT_FOUND.value(), me.getMessage(), "Mobile Details are not Present in between these price");
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> mobileNotFoundModel(MobileNotFoundByModelException me){
		return createErrorStructure(HttpStatus.NOT_FOUND.value(), me.getMessage(), "Mobile Details are not Present in between these price");
	}
	
}
