package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Address;
import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@GetMapping(value = "/getAllEmployee")
	public List<Employee> getAllEmployees () {
		return employeeRepository.findAll();
	}
	@PostMapping("/insertEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}
}
