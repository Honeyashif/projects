package com.jsp.springboot.employee_management_system.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.employee_management_system.entity.Department;
import com.jsp.springboot.employee_management_system.entity.Employee;
import com.jsp.springboot.employee_management_system.utility.ResponseStructure;

public interface EmployeeService {
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(Employee employee);
	
	public ResponseEntity<ResponseStructure<Employee>> findByEmployeeId(int employeeId);
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee();
	
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeDeatails(Employee employee);
	
	public ResponseEntity<ResponseStructure<String>> deleteEmplyeeById(int employeeId);
	
	public ResponseEntity<ResponseStructure<Employee>> AssingEmployeeToDepartment(int employeeId,int departmentId);
	
	public ResponseEntity<ResponseStructure<Employee>> removeEmployeeFromDepartment(int employeeId);
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByDepartment(int departmentId);
	
	public ResponseEntity<ResponseStructure<Department>> createDepartment(Department department);
	
	public ResponseEntity<ResponseStructure<Department>> findDepartmentById(int departmentId);
	
	public ResponseEntity<ResponseStructure<List<Department>>> findAllDepartmrnt();
	
	public ResponseEntity<ResponseStructure<Department>> updateDepartmentDetails(Department department);
	
	public ResponseEntity<ResponseStructure<String>> deleteDeaprtmentById(int departmentId);
	
	public ResponseEntity<ResponseStructure<Map<Department,Integer>>> getDepartmentWithEMployeeCount(int departmentId);
	
	public ResponseEntity<ResponseStructure<Double>> totalSalaryOfDepartment(int deaprtmentId);
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByJobTitle(String job);
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeWithSalaryGreaterThan(int employeeSalary);
	
	public ResponseEntity<ResponseStructure<Employee>> transferEmployeeToAnotherDepartment(int employeeId,int departmentId);
	
	public ResponseEntity<ResponseStructure<List<Department>>> getDeaprtmentsWithMinimunEmployeeCount(int minCount);
	
	
}