package com.jsp.springboot.employee_management_system.serviceimpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.employee_management_system.entity.Department;
import com.jsp.springboot.employee_management_system.entity.Employee;
import com.jsp.springboot.employee_management_system.exception.DepartmentNotFoundByIdException;
import com.jsp.springboot.employee_management_system.exception.EmployeeNotFoundByDepartmentIdException;
import com.jsp.springboot.employee_management_system.exception.EmployeeNotFoundByIdException;
import com.jsp.springboot.employee_management_system.exception.EmployeeNotFoundByJobException;
import com.jsp.springboot.employee_management_system.repository.DepartmentRepository;
import com.jsp.springboot.employee_management_system.repository.EmployeeRepository;
import com.jsp.springboot.employee_management_system.service.EmployeeService;
import com.jsp.springboot.employee_management_system.utility.ResponseStructure;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	private ResponseStructure<Employee> createResponseStructure(int statusCode,String message,Employee data){
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		responseStructure.setStatusCode(statusCode);
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		
		return responseStructure;
	}
	
	private ResponseStructure<List<Employee>> createResponseStructure(int statusCode,String message,List<Employee> data){
		ResponseStructure<List<Employee>> responseStructure=new ResponseStructure<List<Employee>>();
		responseStructure.setStatusCode(statusCode);
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		
		return responseStructure;
	}
	
	private ResponseStructure<String> createResponseStructure(int statusCode,String message,String data){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatusCode(statusCode);
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		
		return responseStructure;
	}
	
	private ResponseStructure<Double> createResponseStructure(int statusCode,String message,Double data){
		ResponseStructure<Double> responseStructure=new ResponseStructure<Double>();
		responseStructure.setStatusCode(statusCode);
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		
		return responseStructure;
	}
	
	private ResponseStructure<Department> createResponseStructure(int statusCode,String message,Department data){
		ResponseStructure<Department> responseStructure=new ResponseStructure<Department>();
		responseStructure.setStatusCode(statusCode);
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		
		return responseStructure;
	}
	
	private ResponseStructure<List<Department>> createResponseStructure(int statusCode,List<Department> data,String message){
		ResponseStructure<List<Department>> responseStructure=new ResponseStructure<List<Department>>();
		responseStructure.setStatusCode(statusCode);
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		
		return responseStructure;
	}
	
	private ResponseStructure<Map<Department,Integer>> createResponseStructure(int statusCode,String message,Map<Department,Integer> data){
		ResponseStructure<Map<Department,Integer>> responseStructure=new ResponseStructure<Map<Department,Integer>>();
		responseStructure.setStatusCode(statusCode);
		responseStructure.setMessage(message);
		responseStructure.setData(data);
		
		return responseStructure;
	}
	
	@Override
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(Employee employee) {
		
		return new ResponseEntity<ResponseStructure<Employee>>(createResponseStructure
				(HttpStatus.CREATED.value(), "Employee Data Added to Database", employeeRepository.save(employee)), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> findByEmployeeId(int employeeId) {
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
		                                   new EmployeeNotFoundByIdException("Employee Not Present in thr database for this Specified Id"));
		
		
		return new ResponseEntity<ResponseStructure<Employee>>(createResponseStructure
				(HttpStatus.FOUND.value(), "Employee Details Fetched Succesfully!!",employee), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
		
		return new ResponseEntity<ResponseStructure<List<Employee>>>(createResponseStructure
				(HttpStatus.FOUND.value(),"All Employee Details Fetched Succesufully!!" , employeeRepository.findAll()), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeDeatails(Employee updatedEmployee) {
		Employee employee=employeeRepository.findById(updatedEmployee.getEmployeeId()).orElseThrow(()->
		                  new EmployeeNotFoundByIdException("We Dont have details in the detabase for this Id to Update"));
		
		updatedEmployee.setEmployeeId(employee.getEmployeeId());
		
		return new ResponseEntity<ResponseStructure<Employee>>(createResponseStructure
				(HttpStatus.CREATED.value(), "Updated Succesufully!!", employeeRepository.save(updatedEmployee)), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteEmplyeeById(int employeeId) {
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
                         new EmployeeNotFoundByIdException("We Dont have details in the detabase for this Id to Delete"));
		
		employeeRepository.delete(employee);
		
		return new ResponseEntity<ResponseStructure<String>>(createResponseStructure
				(HttpStatus.OK.value(), "Deleted Succesufully", "Deleted"), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> AssingEmployeeToDepartment(int employeeId, int departmentId) {
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
		                  new EmployeeNotFoundByIdException("We Dont have details in the detabase for this id"));
		
		Department department=departmentRepository.findById(departmentId).orElseThrow(()->
		                         new DepartmentNotFoundByIdException("Department Deatails are not present for this id"));
		
		employee.setDepartment(department);
		
		return new ResponseEntity<ResponseStructure<Employee>>(createResponseStructure
				(HttpStatus.CREATED.value(), "Data Assigned Succesufully", employeeRepository.save(employee)), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> removeEmployeeFromDepartment(int employeeId) {
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
                                   new EmployeeNotFoundByIdException("We Dont have details in the detabase for this id"));
		employee.setDepartment(null);
		
		ResponseStructure<Employee> responseStructure=createResponseStructure
				(HttpStatus.OK.value(), "Employee Removed From the Department", employeeRepository.save(employee));
		
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByDepartment(int departmentId) {
		Department department=departmentRepository.findById(departmentId).orElseThrow(()->
		                new DepartmentNotFoundByIdException("Department Not Found With id which u Specified"));
		
		List<Employee> employees=employeeRepository.findByDepartment_DepartmentId(department.getDepartmentId());
		
		if(employees.isEmpty())
			throw new EmployeeNotFoundByDepartmentIdException("Employees Not Present in this Department");
		else {
			return new ResponseEntity<ResponseStructure<List<Employee>>>(createResponseStructure
					(HttpStatus.FOUND.value(), "In "+departmentId+" department Employees are", employees), HttpStatus.FOUND);
		}
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Department>> createDepartment(Department department) {
		
		return new ResponseEntity<ResponseStructure<Department>>(createResponseStructure
				(HttpStatus.CREATED.value(), "Deapartment Added Succesufully!!", departmentRepository.save(department)),HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Department>> findDepartmentById(int departmentId) {
		
		return new ResponseEntity<ResponseStructure<Department>>(createResponseStructure
				(HttpStatus.FOUND.value(), "Department Fetched for "+departmentId, departmentRepository.findById(departmentId).
						orElseThrow(()->new DepartmentNotFoundByIdException("Department Not Found with "+departmentId))),HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Department>>> findAllDepartmrnt() {
		
		return new ResponseEntity<ResponseStructure<List<Department>>>(createResponseStructure
				(HttpStatus.FOUND.value(), departmentRepository.findAll(), "All Department Details Founded"),HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<Department>> updateDepartmentDetails(Department updatedDepartment) {
		Department department=departmentRepository.findById(updatedDepartment.getDepartmentId()).
				orElseThrow(()->new DepartmentNotFoundByIdException("Department Not Found with "));
		
		updatedDepartment.setDepartmentId(department.getDepartmentId());
		
		return new ResponseEntity<ResponseStructure<Department>>(createResponseStructure
				 (HttpStatus.CREATED.value(), "Updated Succesufully!!", departmentRepository.save(updatedDepartment)),HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteDeaprtmentById(int departmentId) {
		Department department=departmentRepository.findById(departmentId).
				orElseThrow(()->new DepartmentNotFoundByIdException("Department Not Found with "));
		departmentRepository.delete(department);
		
		return new ResponseEntity<ResponseStructure<String>>(createResponseStructure(HttpStatus.OK.value(), "Deleted Succesufully!!", "Deleted"),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Map<Department,Integer>>> getDepartmentWithEMployeeCount(
			int departmentId) {
		Department department=departmentRepository.findById(departmentId).
				orElseThrow(()->new DepartmentNotFoundByIdException("Department Not Found with "));	
		int count=(int) department.getEmployees().stream().count();
		Map<Department, Integer> map=new LinkedHashMap<Department, Integer>();
		map.put(department, count);
		
		return new ResponseEntity<ResponseStructure<Map<Department,Integer>>>(createResponseStructure
				(HttpStatus.OK.value(), "Departments and there Employee Count",map),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Double>> totalSalaryOfDepartment(int deaprtmentId) {
		Department department=departmentRepository.findById(deaprtmentId).
				orElseThrow(()->new DepartmentNotFoundByIdException("Department Not Found with "));
		Double count=departmentRepository.findTotalSalaryByDepartmentId(department.getDepartmentId());
		
		return new ResponseEntity<ResponseStructure<Double>>(createResponseStructure
				(HttpStatus.OK.value(), "Count of Department with "+deaprtmentId+" is", count),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByJobTitle(String job) {
		List<Employee> employees=employeeRepository.findByEmployeeJob(job);
		if(employees.isEmpty())
			throw new EmployeeNotFoundByJobException("Employee Not Found");
		else {
			return new ResponseEntity<ResponseStructure<List<Employee>>>(createResponseStructure
					(HttpStatus.FOUND.value(), "Employee Present in the "+job+" Job", employees),HttpStatus.FOUND);
		}
			
		
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeWithSalaryGreaterThan(int employeeSalary) {
		
		return new ResponseEntity<ResponseStructure<List<Employee>>>(createResponseStructure
				(HttpStatus.FOUND.value(), "Employee Details Whose Salary Greater Than "+employeeSalary, employeeRepository.findBySalaryGreaterThan(employeeSalary)),HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<Employee>> transferEmployeeToAnotherDepartment(int employeeId,
			int departmentId) {
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new EmployeeNotFoundByIdException("Employee Not Found"));
		
		Department department=departmentRepository.findById(departmentId).orElseThrow(()->new DepartmentNotFoundByIdException("Department Not Found By ID"));
		
		employee.setDepartment(department);
		
		return new ResponseEntity<ResponseStructure<Employee>>(createResponseStructure
				(HttpStatus.CREATED.value(), "Trasferd Succesufully!!", employeeRepository.save(employee)),HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Department>>> getDeaprtmentsWithMinimunEmployeeCount(int minCount) {
		
		return new ResponseEntity<ResponseStructure<List<Department>>>(createResponseStructure
				(HttpStatus.FOUND.value(),  departmentRepository.findDepartmentWithMinimumEmployees(minCount),"Department"),HttpStatus.FOUND);
	}

}
