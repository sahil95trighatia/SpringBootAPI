package com.SpringAPI.springAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringAPI.springAPI.model.Employee;
import com.SpringAPI.springAPI.repository.employeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private employeeRepository eRepository;
	
	
	@Override
	public List<Employee> getEmployees() {
		return eRepository.findAll();
	}


	@Override
	public Employee saveEmployees(Employee employee) {
		return eRepository.save(employee);
	}


	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee =  eRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("employee is not found for the id " + id);
	}


	@Override
	public void deleteEmployee(Long id) {
	return;

	}

	@Override
	public Employee updateEmployees(Employee employee) {
		// TODO Auto-generated method stub
		return eRepository.save(employee);
	}


	@Override
	public List<Employee> getEmployeeName(String name) {
		return eRepository.findByName(name);
	}

}