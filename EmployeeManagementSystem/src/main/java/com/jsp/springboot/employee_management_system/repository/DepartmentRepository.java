package com.jsp.springboot.employee_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.springboot.employee_management_system.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	
	public Double findTotalSalaryByDepartmentId(int departmentId);

	@Query("SELECT d FROM Department d JOIN d.employees e GROUP BY d.id ORDER BY COUNT(e) ASC")
	public List<Department> findDepartmentWithMinimumEmployees(@Param("minEmployeeCount") int minEmployeeCount); 
}
