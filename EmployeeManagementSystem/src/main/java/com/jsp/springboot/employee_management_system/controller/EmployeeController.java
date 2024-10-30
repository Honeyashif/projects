package com.jsp.springboot.employee_management_system.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.employee_management_system.entity.Department;
import com.jsp.springboot.employee_management_system.entity.Employee;
import com.jsp.springboot.employee_management_system.service.EmployeeService;
import com.jsp.springboot.employee_management_system.utility.ResponseStructure;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee/add")
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/employee/find-by-id")
	public ResponseEntity<ResponseStructure<Employee>> findByEmployeeId(int employeeId) {
		return employeeService.findByEmployeeId(employeeId);
	}
	
	@GetMapping("/emplyee/find-all")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
		return employeeService.findAllEmployee();
	}
	
	@PutMapping("/employee/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeDeatails(@RequestBody Employee updatedEmployee) {
		return employeeService.updateEmployeeDeatails(updatedEmployee);
	}
	
	@DeleteMapping("/employee/delete-by-id")
	public ResponseEntity<ResponseStructure<String>> deleteEmplyeeById(int employeeId) {
		return employeeService.deleteEmplyeeById(employeeId);
	}
	
	@PostMapping("/employees/assign-to-department")
	public ResponseEntity<ResponseStructure<Employee>> AssingEmployeeToDepartment(int employeeId, int departmentId) {
		return employeeService.AssingEmployeeToDepartment(employeeId, departmentId);
	}
	
	@PostMapping("/employees/remove-from-department")
	public ResponseEntity<ResponseStructure<Employee>> removeEmployeeFromDepartment(int employeeId) {
		return employeeService.removeEmployeeFromDepartment(employeeId);
	}

	@GetMapping("/employees/find-by-department-id")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByDepartment(int departmentId) {
		return employeeService.getEmployeeByDepartment(departmentId);
	}
		
	@PostMapping("/department/save")
	public ResponseEntity<ResponseStructure<Department>> createDepartment(@RequestBody Department department) {
		return employeeService.createDepartment(department);
	}

	@GetMapping("/department/find-by-id")
	public ResponseEntity<ResponseStructure<Department>> findDepartmentById(int departmentId) {
		return employeeService.findDepartmentById(departmentId);
	}

	@GetMapping("/departments/find-all")
	public ResponseEntity<ResponseStructure<List<Department>>> findAllDepartmrnt() {
		return employeeService.findAllDepartmrnt();
	}

	@PutMapping("/departments/update-by-id")
	public ResponseEntity<ResponseStructure<Department>> updateDepartmentDetails(@RequestBody Department updatedDepartment) {
		return employeeService.updateDepartmentDetails(updatedDepartment);
	}

	@DeleteMapping("department/delete-by-id")
	public ResponseEntity<ResponseStructure<String>> deleteDeaprtmentById(int departmentId) {
		return employeeService.deleteDeaprtmentById(departmentId);
	}

	@GetMapping("/department/count")
	public ResponseEntity<ResponseStructure<Map<Department,Integer>>> getDepartmentWithEMployeeCount(
			int departmentId) {
		return employeeService.getDepartmentWithEMployeeCount(departmentId);
	}

	@GetMapping("/department/total-salary")
	public ResponseEntity<ResponseStructure<Double>> totalSalaryOfDepartment(int departmentId) {
		return employeeService.totalSalaryOfDepartment(departmentId);
	}

	@GetMapping("/employees/by-job-title")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByJobTitle(String job) {
		return employeeService.getEmployeeByJobTitle(job);
	}
			
		
	@GetMapping("/employees/find-by-greater-than-salary")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeWithSalaryGreaterThan(int employeeSalary) {
		return employeeService.getEmployeeWithSalaryGreaterThan(employeeSalary);
	}

	@PostMapping("/transfer")
	public ResponseEntity<ResponseStructure<Employee>> transferEmployeeToAnotherDepartment(int employeeId,
			int departmentId) {
		return employeeService.transferEmployeeToAnotherDepartment(employeeId, departmentId);
	}

	@GetMapping("/department/find-by-min-employee-count")
	public ResponseEntity<ResponseStructure<List<Department>>> getDeaprtmentsWithMinimunEmployeeCount(int minCount) {
		return employeeService.getDeaprtmentsWithMinimunEmployeeCount(minCount);
	}
}
