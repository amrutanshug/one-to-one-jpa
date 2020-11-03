package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.practice.model.ClassModel;

@RestController
public class ClassController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/sayHelloFromApiCall")
	public String sayHelloFromApiCall(){
		
		String url = "http://localhost:8080/hello";
		String obj = restTemplate.getForObject(url, String.class);
		return obj;
	}
	
	@GetMapping("/getAllClassesFromApiCall")
	public ResponseEntity<List<ClassModel>> getClassesFromApiCall(){
		
		String url = "http://localhost:8080/getAllClassesInfo";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		Gson gson = new Gson();
		if(response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {
			List<ClassModel> classesString = gson.fromJson(response.getBody(), new TypeToken<List<ClassModel>>() {}.getType());
		 //= gson.to(response.getBody(), List<ClassModel>.class);
		
			return new ResponseEntity<> (classesString, HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	
}
