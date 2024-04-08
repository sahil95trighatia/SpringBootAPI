package com.SpringAPI.springAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringAPI.springAPI.model.Employee;


@Repository
public interface employeeRepository  extends JpaRepository<Employee, Long>{
	
	
	List<Employee> findByName(String name);

}
