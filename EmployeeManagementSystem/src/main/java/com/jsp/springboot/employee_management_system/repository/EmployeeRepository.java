package com.jsp.springboot.employee_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.springboot.employee_management_system.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByDepartment_DepartmentId(int departmentId);
	
	public List<Employee> findByEmployeeJob(String job);
	
	public List<Employee> findBySalaryGreaterThan(int salary);
	
}
