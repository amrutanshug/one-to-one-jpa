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

import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;
import com.test.response.entity.AddressModel;
import com.test.response.entity.EmployeeModel;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
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
	public AddressModel getAddressByEmployeeId(@PathVariable Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		Employee e2 = employee.get();
		/*
		 * Address address = new Address();
		 * address.setAddressProofId(e2.getAddress().getAddressProofId());
		 * address.setCity(e2.getAddress().getCity());
		 * address.setCountry(e2.getAddress().getCountry());
		 * address.setHouseNo(e2.getAddress().getHouseNo());
		 * address.setState(e2.getAddress().getState());
		 * address.setStreet(e2.getAddress().getStreet());
		 * 
		 * Employee returnE = new Employee(); returnE.setId(e2.getId());
		 * returnE.setName(e2.getName()); returnE.setPosition(e2.getPosition());
		 * address.setEmployee(returnE);
		 */
		
		AddressModel responseAddress = new AddressModel(e2.getAddress().getAddressProofId(),e2.getAddress().getHouseNo(),
				e2.getAddress().getStreet(),e2.getAddress().getCity(),e2.getAddress().getState(),e2.getAddress().getCountry());
		return responseAddress;
	}
	
	
	
}
