package com.jsp.springboot.mobile_management_system.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.mobile_management_system.entity.Mobile;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundBetweenPrice;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundByBrandException;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundByIdException;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundByModelException;
import com.jsp.springboot.mobile_management_system.exception.MobileNotFoundByOperatingSystem;
import com.jsp.springboot.mobile_management_system.repository.MobileRepository;
import com.jsp.springboot.mobile_management_system.service.MobileService;
import com.jsp.springboot.mobile_management_system.utility.ResponseStructure;

@Service
public class MobileServiceImpl implements MobileService{

	@Autowired
	private MobileRepository mobileRepository;
	
	private ResponseStructure<Mobile> createResponse(int statusCode,String message,Mobile data){
		ResponseStructure<Mobile> responseStructure=new ResponseStructure<Mobile>();
		responseStructure.setStatusCode(statusCode);
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		
		return responseStructure;
	}
	
	private ResponseStructure<String> createResponse(int statusCode,String message,String data){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(statusCode);
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		
		return responseStructure;
	}

	private ResponseStructure<List<Mobile>> createResponse(int statusCode,String message,List<Mobile> data){
		ResponseStructure<List<Mobile>> responseStructure=new ResponseStructure<List<Mobile>>();
		responseStructure.setStatusCode(statusCode);
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		
		return responseStructure;
	}
	
	@Override
	public ResponseEntity<ResponseStructure<Mobile>> addMobile(Mobile mobile) {
		Mobile mobile2=mobileRepository.save(mobile);

		ResponseStructure<Mobile> responseStructure=createResponse(HttpStatus.CREATED.value(), "Mobile Details Added SUccessufully!!", mobile2);

		return new ResponseEntity<ResponseStructure<Mobile>>(responseStructure, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Mobile>> updateMobile(Mobile mobile) {
		Mobile mobile2=mobileRepository.findById(mobile.getMobileId()).orElseThrow(()->
		                                    new MobileNotFoundByIdException("Mobile Not Found in the Database"));

		mobile.setMobileId(mobile2.getMobileId());
		mobileRepository.save(mobile);

		ResponseStructure<Mobile> responseStructure=createResponse(HttpStatus.CREATED.value(), "Updated Sucessufully!!", mobile);
		
		return new ResponseEntity<ResponseStructure<Mobile>>(responseStructure, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteMobilebyId(int mobileId) {
		Mobile mobile=mobileRepository.findById(mobileId).orElseThrow(()->
		                                      new MobileNotFoundByIdException("Mobile Details Are Not Present for that Id"));

		mobileRepository.delete(mobile);

		ResponseStructure<String> responseStructure=createResponse(HttpStatus.OK.value(), "Deleted Sucessufully!!", "deleted");

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Mobile>> findMobileById(int mobileId) {
		Mobile mobile=mobileRepository.findById(mobileId).orElseThrow(()->
		                                      new MobileNotFoundByIdException("Mobile Details Are Not Present for that Id"));
		
		ResponseStructure<Mobile> responseStructure=createResponse(HttpStatus.FOUND.value(), "Mobile Details Founded SUccessufully!!", mobile);

		return new ResponseEntity<ResponseStructure<Mobile>>(responseStructure, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Mobile>>> findAllMobile() {
		List<Mobile> mobiles=mobileRepository.findAll();

		ResponseStructure<List<Mobile>> responseStructure=createResponse(HttpStatus.FOUND.value(), "Mobile Details Founded SUccessufully!!", mobiles);
		
		return new ResponseEntity<ResponseStructure<List<Mobile>>>(responseStructure, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileByBrand(String mobileBrand) {
		List<Mobile> mobiles=mobileRepository.findByMobileBrand(mobileBrand);
		
		if(mobiles.isEmpty())
			throw new MobileNotFoundByBrandException("Mobile Not Found By Name");
		else {
			ResponseStructure<List<Mobile>> responseStructure=createResponse(HttpStatus.FOUND.value(), "Mobile Details Founded SUccessufully!!", mobiles);

			return new ResponseEntity<ResponseStructure<List<Mobile>>>(responseStructure, HttpStatus.FOUND);
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileBetweenPrice(double lowprice, double highprice) {
		List<Mobile> mobiles=mobileRepository.findByMobilePriceBetween(lowprice, highprice);
		if(mobiles.isEmpty()) {
			throw new MobileNotFoundBetweenPrice("Mobile Not Found Between");
		}
		else {
			ResponseStructure<List<Mobile>> responseStructure=createResponse(HttpStatus.FOUND.value(), "Mobile Details Founded SUccessufully!!", mobiles);
		
			return new ResponseEntity<ResponseStructure<List<Mobile>>>(responseStructure, HttpStatus.FOUND);
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileByModel(String mobileModel) {
		List<Mobile> mobiles=mobileRepository.findByMobileModel(mobileModel);
		
		if(mobiles.isEmpty())
			throw new MobileNotFoundByModelException("No more Mobiles In this Model");
		else {
		ResponseStructure<List<Mobile>> responseStructure=createResponse(HttpStatus.FOUND.value(), "Mobile Details in this Model!!", mobiles);
		
		return new ResponseEntity<ResponseStructure<List<Mobile>>>(responseStructure, HttpStatus.FOUND);
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Mobile>>> findMobileByOperatingSystem(String operatingSystem) {
		List<Mobile> mobiles=mobileRepository.findByOperatingSystem(operatingSystem);
		
		if(mobiles.isEmpty())
			throw new MobileNotFoundByOperatingSystem("Mobile are Not Available in this Os");
		else {
		ResponseStructure<List<Mobile>> responseStructure=createResponse(HttpStatus.FOUND.value(), "Mobile Details Founded SUccessufully!!", mobiles);
		
		return new ResponseEntity<ResponseStructure<List<Mobile>>>(responseStructure, HttpStatus.FOUND);
		}
	}

}
