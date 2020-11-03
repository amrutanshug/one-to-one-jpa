package com.practice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Course;
import com.practice.entity.Student;
import com.practice.model.StudentModel;
import com.practice.repository.CourseRepository;
import com.practice.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping(value = "getAllStudents")
	public ResponseEntity<List<StudentModel>> getAllStudents (){
		List<StudentModel> students = new ArrayList<>();
		List<Student> studentsFromDb = new ArrayList<>();
		studentRepository.findAll().forEach(studentsFromDb::add);
		if(studentsFromDb.isEmpty()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		} else {
		for (Student student : studentsFromDb) {
			
			StudentModel stu = new StudentModel(student.getRollNo(), student.getName(), student.getInClass());
			
			students.add(stu);
		}
		return new ResponseEntity<List<StudentModel>> (students, HttpStatus.OK);
		}
	}
	
	@PutMapping(value = "/assignCoursesToStudent/{rollNo}")
	public ResponseEntity<Student> assignCoursesToStudent(@PathVariable Long rollNo, @RequestBody List<String> courseNames){
		
		if(studentRepository.findById(rollNo).isEmpty()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		} else {
			Student student = studentRepository.findById(rollNo).get();
			Set<Course> coursesToAssign = student.getCourses();
			try {
				for (String course2 : courseNames) {
					Course course = courseRepository.findById(course2).get();
					coursesToAssign.add(course);
				}
				student.setCourses(coursesToAssign);
				studentRepository.save(student);
				return new ResponseEntity<> (student, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
			}
		}
	}
	
}
