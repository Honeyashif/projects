package com.jsp.springboot.mobile_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mobile {
	@Id
	private int mobileId;
	private String mobileBrand;
	private String mobileModel;
	private double mobilePrice;
	private int batteryCapacity;
	private String mobileColor;
	private String operatingSystem;
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getMobileBrand() {
		return mobileBrand;
	}
	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}
	public String getMobileModel() {
		return mobileModel;
	}
	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}
	public double getMobilePrice() {
		return mobilePrice;
	}
	public void setMobilePrice(double mobilePrice) {
		this.mobilePrice = mobilePrice;
	}
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public String getMobileColor() {
		return mobileColor;
	}
	public void setMobileColor(String mobileColor) {
		this.mobileColor = mobileColor;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
}
