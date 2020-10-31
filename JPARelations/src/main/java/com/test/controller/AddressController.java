package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Address;
import com.test.repository.AddressRepository;

@RestController
public class AddressController {
	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping(value = "/allAddress")
	public List<Address> getAllAddress (){
		return addressRepository.findAll();
	}
	
	@PostMapping("/insertAddress")
	public void addAddress(@RequestBody Address address) {
		addressRepository.save(address);
	}
}
