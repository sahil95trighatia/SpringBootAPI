package com.SpringAPI.springAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringAPI.springAPI.model.Employee;
import com.SpringAPI.springAPI.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
//@RequestMapping("/api/v1/")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService eService; 
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	
	@GetMapping("/version")
	public String getAppDetails() {
		return appName + " - " + appVersion;
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {       // handler method
		return new ResponseEntity<List<Employee>>(eService.getEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")       /// map the handler method with URL.
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
		System.out.println("fetching the employee id");
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id), HttpStatus.PARTIAL_CONTENT);
	}
	
	@GetMapping("/employee/findByName")       /// map the handler method with URL.
	public ResponseEntity<List<Employee>> getEmployee(@RequestParam("name") String name) {
		System.out.println("fetching the employee id");
		return new ResponseEntity<List<Employee>>(eService.getEmployeeName(name), HttpStatus.OK);
	}
	
	@DeleteMapping("/employee")
	public ResponseEntity<Employee> deleteEmployee(@RequestParam("id") long id) {
		 System.out.println("deleting the employee details for the id ");
		return null;
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		System.out.println("update the employee details ");
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployees(employee), HttpStatus.OK);
	}

	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		System.out.println("save the employee deatisl");
		return new ResponseEntity<Employee>(eService.saveEmployees(employee), HttpStatus.CREATED);
	}
	
}
