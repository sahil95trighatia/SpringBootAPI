package com.SpringAPI.springAPI.service;

import java.util.List;

import com.SpringAPI.springAPI.model.Employee;

public interface EmployeeService {
	
	
	List<Employee> getEmployees();
	
	Employee saveEmployees(Employee employee);
	
	Employee getSingleEmployee(Long id);
	
	void deleteEmployee(Long id);
	
	Employee updateEmployees(Employee employee);
	
	List<Employee> getEmployeeName(String name);

	
	

}
