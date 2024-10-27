package com.jsp.springboot.mobile_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.mobile_management_system.entity.Mobile;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundByBrandException;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundByIdException;
import com.jsp.springboot.mobile_management_system.service.MobileService;
import com.jsp.springboot.mobile_management_system.utility.ResponseStructure;

@RestController
public class MobileController {
	@Autowired
	private MobileService mobileService;
	
	@PostMapping("/mobiles/add")
	public ResponseEntity<ResponseStructure<Mobile>> addMobile(@RequestBody Mobile mobile) {
		return mobileService.addMobile(mobile);
	}
	
	@PutMapping("/mobiles/update-mobile-by-id")
	public ResponseEntity<ResponseStructure<Mobile>> updateMobile(@RequestBody Mobile mobile) {
		return mobileService.updateMobile(mobile);
	}
	
	@DeleteMapping("/mobiles/delete-by-id")
	public ResponseEntity<ResponseStructure<String>> deleteMobilebyId(int mobileId) {
		return mobileService.deleteMobilebyId(mobileId);
	}
	
	@GetMapping("/mobiles/find-all")
	public ResponseEntity<ResponseStructure<List<Mobile>>> findAllMobile() {
		return mobileService.findAllMobile();
	}
	
	@GetMapping("/mobiles/find-by-id" )
	public ResponseEntity<ResponseStructure<Mobile>> findMobileById(int mobileId) {
		return mobileService.findMobileById(mobileId);
	}
	
	@GetMapping("/mobiles/find-by-brand")
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileByBrand(String mobileBrand) {
		return mobileService.findMobileByBrand(mobileBrand);
	}
	
	@GetMapping("/mobiles/find-between")
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileBetweenPrice(double mobilePrice1, double mobilePrice2) {
		return mobileService.findMobileBetweenPrice(mobilePrice1, mobilePrice2);
	}
	
	@GetMapping("/mobiles/find-by-model")
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileByModel(String mobileModel) {
		return mobileService.findMobileByModel(mobileModel);
	}
	
	@GetMapping("/mobile/find-by-os")
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileByOperatingSystem(String operatingSystem) {
		return mobileService.findMobileByOperatingSystem(operatingSystem);
	}
}
