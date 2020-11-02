package com.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Course;
import com.practice.model.CourseModel;
import com.practice.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping(value = "getAllCourses")
	public ResponseEntity<List<CourseModel>> getAllCourses (){
		List<CourseModel> courses = new ArrayList<>();
		List<Course> courseFromDb = new ArrayList<>();
		courseRepository.findAll().forEach(courseFromDb::add);
		if(courseFromDb.isEmpty()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		} else {
		for (Course course : courseFromDb) {
			CourseModel courseModel= new CourseModel();
			courseModel.setCourseName(course.getCourseName());
			courseModel.setDescription(course.getDescription());
			courseModel.setDurationInYears(course.getDurationInYears());
			courses.add(courseModel);
		}
		return new ResponseEntity<List<CourseModel>> (courses, HttpStatus.OK);
		}
	}
}
