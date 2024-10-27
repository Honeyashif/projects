package com.jsp.springboot.mobile_management_system.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.mobile_management_system.entity.Mobile;
import com.jsp.springboot.mobile_management_system.utility.ResponseStructure;

public interface MobileService {
	
	public ResponseEntity<ResponseStructure<Mobile>> addMobile(Mobile mobile);
	
	public ResponseEntity<ResponseStructure<Mobile>> updateMobile(Mobile mobile);
	
	public ResponseEntity<ResponseStructure<String>> deleteMobilebyId(int mobileId);
	
	public ResponseEntity<ResponseStructure<Mobile>> findMobileById(int mobileId);
	
	public ResponseEntity<ResponseStructure<List<Mobile>>> findAllMobile();
	
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileByBrand(String mobileBrand);
	
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileBetweenPrice(double lowprice,double highprice);
	
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileByModel(String mobileModel);
	
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileByOperatingSystem(String operatingSystem);
	
}
