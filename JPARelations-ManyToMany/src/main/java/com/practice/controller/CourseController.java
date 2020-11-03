package com.practice.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Course;
import com.practice.entity.Student;
import com.practice.model.CourseModel;
import com.practice.repository.CourseRepository;
import com.practice.repository.StudentRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
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
	
	@PostMapping(value = "/addCourseWithoutStudent")
	public ResponseEntity<CourseModel> addCourseWithoutStudent(@RequestBody CourseModel course){
		try {
			if(course == null) {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}else {
				Course course2 = new Course();
				course2.setCourseName(course.getCourseName());
				course2.setDescription(course.getDescription());
				course2.setDurationInYears(course.getDurationInYears());
				courseRepository.save(course2);
				return new ResponseEntity<> (HttpStatus.ACCEPTED);
			}
		}catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping(value = "/assignCourseToStudents/{courseName}")
	public ResponseEntity<Course> addCourseWithStudent(@PathVariable String courseName, @RequestBody List<Long> rolls){
		if(courseRepository.findById(courseName).isEmpty()) {
			return new ResponseEntity<Course> (HttpStatus.NOT_FOUND);
		}else {
			Course course = courseRepository.findById(courseName).get();
			Set<Student> studentsToUpdate = course.getStudents();
			try {
				for (Long roll : rolls) {
					Student student = studentRepository.findById(roll).get();
					studentsToUpdate.add(student);
				}
				course.setStudents(studentsToUpdate);
				courseRepository.save(course);
				return new ResponseEntity<> (course, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
			}
		}
	}
	
}
