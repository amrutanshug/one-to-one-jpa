package com.practice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.entity.ClassOfStudent;
import com.practice.entity.Student;
import com.practice.repository.ClassRepository;
import com.practice.repository.StudentRepository;
import com.practice.responsemodel.ClassModel;
import com.practice.responsemodel.StudentModel;

@Controller
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ClassRepository classRepository;
	
	@GetMapping(value="/getAllStudents")
	public ResponseEntity<List<StudentModel>> getAllStudents(){
		
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		
		List<StudentModel> returnModel = new ArrayList<>();
		
		for (Student student : students) {
			StudentModel studentModel = new StudentModel(student.getRollNo(), student.getName(),
					student.getMarks(), student.getClassOfStudent().getClassNumber());
			returnModel.add(studentModel);
		}
		
		if (returnModel.isEmpty()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<StudentModel>> (returnModel, HttpStatus.OK);
		}		
	}
	
	@PostMapping(value = "/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody StudentModel studentModel){
		try {
			Student student = new Student();
			Optional<ClassOfStudent> classOfStudent = classRepository.findById(studentModel.getClassNumber());
			if(classOfStudent.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				ClassOfStudent classToBeAdded = classOfStudent.get();
				
				student.setClassOfStudent(classToBeAdded);
				student.setMarks(studentModel.getMarks());
				student.setName(studentModel.getName());
				
				studentRepository.save(student);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			
		} catch (Exception e){
		return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
	}
	
}
