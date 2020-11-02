package com.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Address;
import com.test.entity.Employee;
import com.test.repository.AddressRepository;
import com.test.repository.EmployeeRepository;

@RestController
public class AddressController {
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping(value = "/allAddress")
	public List<Address> getAllAddress (){
		return addressRepository.findAll();
	}
	
	@PostMapping("/insertAddress")
	public void addAddress(@RequestBody Address address) {
		addressRepository.save(address);
	}
	
	
}
