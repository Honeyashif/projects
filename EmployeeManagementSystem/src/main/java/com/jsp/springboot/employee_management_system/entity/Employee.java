package com.jsp.springboot.employee_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	private int employeeId;
	private String employeeName;
	private String employeeJob;
	private int MGR;
	private double salary;
	private int COMM;
	
	@ManyToOne
	private Department department;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeJob() {
		return employeeJob;
	}

	public void setEmployeeJob(String employeeJob) {
		this.employeeJob = employeeJob;
	}

	public int getMGR() {
		return MGR;
	}

	public void setMGR(int mGR) {
		MGR = mGR;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getCOMM() {
		return COMM;
	}

	public void setCOMM(int cOMM) {
		COMM = cOMM;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
