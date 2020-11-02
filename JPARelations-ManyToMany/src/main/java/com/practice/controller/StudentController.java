package com.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Course;
import com.practice.entity.Student;
import com.practice.model.CourseModel;
import com.practice.model.StudentModel;
import com.practice.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
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
}
