package com.practice.controller;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@RestController
public class StudentController {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/updateStudentBasedOnRollNoByApiCall/{classNo}/{rollNo}")
	public ResponseEntity<HttpStatus> updateStudentBasedOnRollNoByApiCall(@PathVariable Integer classNo, 
			@PathVariable Long rollNo){
		try {
		String url = "http://localhost:8080/updateStudentBasedOnRollNo/"+classNo+"/"+rollNo;
		/*
		 * Map<String, Object> uriVariables = new HashMap<String, Object>();
		 * uriVariables.put("classNo", classNo); uriVariables.put("rollNo", rollNo);
		 */
		HttpHeaders headers = new HttpHeaders();
	    headers.set("Content-Type", "application/json");
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    
	    
		restTemplate.postForEntity(url, entity, String.class);
		return new ResponseEntity<HttpStatus> (HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<HttpStatus> (HttpStatus.BAD_REQUEST);
		}
	}
	
}
