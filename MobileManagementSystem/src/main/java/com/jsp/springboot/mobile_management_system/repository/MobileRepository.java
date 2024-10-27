package com.jsp.springboot.mobile_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot.mobile_management_system.entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {
	public List<Mobile> findByMobileBrand(String mobileBrand);
	
	public List<Mobile> findByMobilePriceBetween(double lowPrice,double highPrice);
	
	public List<Mobile> findByMobileModel(String model);
	
	public List<Mobile> findByOperatingSystem(String operatingSystem);
}
