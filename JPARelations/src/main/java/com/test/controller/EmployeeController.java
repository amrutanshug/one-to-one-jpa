package com.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Address;
import com.test.entity.Employee;
import com.test.repository.AddressRepository;
import com.test.repository.EmployeeRepository;
import com.test.response.entity.AddressModel;
import com.test.response.entity.EmployeeModel;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	AddressRepository addressRepository;
	@GetMapping(value = "/getAllEmployee")
	public List<EmployeeModel> getAllEmployees () {
		List<Employee> employees = new ArrayList<>();
		List<EmployeeModel> employeesReturnModel = new ArrayList<>();
		
		employeeRepository.findAll().forEach(employees::add);
		for (Employee employee : employees) {
			
			EmployeeModel returnModel = new EmployeeModel(employee.getId(),employee.getName(),employee.getPosition());
			employeesReturnModel.add(returnModel);
		}
		
		
		return employeesReturnModel;
	}
	@PostMapping("/insertEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}
	
	@GetMapping(value = "/employee/{id}/address")
	public ResponseEntity<AddressModel> getAddressByEmployeeId(@PathVariable Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
		Employee e2 = employee.get();
		AddressModel responseAddress = new AddressModel(e2.getAddress().getAddressProofId(),e2.getAddress().getHouseNo(),
				e2.getAddress().getStreet(),e2.getAddress().getCity(),e2.getAddress().getState(),e2.getAddress().getCountry());
		return new ResponseEntity<AddressModel>(responseAddress, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/employee/{id}/address")
	public void updateAdressByEmployeeId(@PathVariable Long id, @RequestBody AddressModel address) {
		
		//ResponseEntity<T> responseEntity = 
		
		Optional<Employee> employee = employeeRepository.findById(id);
		Address address2 = employee.get().getAddress();
		address2.setCity(address.getCity());
		address2.setCountry(address.getCountry());
		address2.setHouseNo(address.getHouseNo());
		address2.setState(address.getState());
		address2.setStreet(address.getStreet());
		try {
		addressRepository.save(address2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
