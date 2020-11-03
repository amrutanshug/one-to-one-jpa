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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.ClassOfStudent;
import com.practice.entity.Student;
import com.practice.repository.ClassRepository;
import com.practice.responsemodel.ClassModel;
import com.practice.responsemodel.StudentModel;

@RestController
public class ClassController {

	@Autowired
	ClassRepository classRepository;
	
	
	@GetMapping(value = "/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping(value = "/getAllClassesInfo")
	public ResponseEntity<List<ClassModel>> getAllClassesInfo(){
		List<ClassOfStudent> classes = new ArrayList<>();
		classRepository.findAll().forEach(classes::add);
		
		List<ClassModel> returnModel = new ArrayList<>();
		
		for (ClassOfStudent classOfStudent : classes) {
			ClassModel classModel = new ClassModel();
			classModel.setClassNumber(classOfStudent.getClassNumber());
			classModel.setDescription(classOfStudent.getDescription());
			classModel.setSchool(classOfStudent.getSchool());
			
			returnModel.add(classModel);
		}
		
		if (returnModel.isEmpty()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<ClassModel>> (returnModel, HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/addClass")
	public ResponseEntity<ClassOfStudent> addClass(@RequestBody ClassModel clasModel){
		try {
			ClassOfStudent classOfStudent = new ClassOfStudent(clasModel.getClassNumber(), clasModel.getDescription(),
					clasModel.getSchool());
			
		classRepository.save(classOfStudent);
		return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e){
		return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/findClass/{classNumber}/students")
	public ResponseEntity<Set<StudentModel>> findStudentsOfAnyClass(@PathVariable Integer classNumber){
		try {
		Set<StudentModel> studentsToBeReturned = new HashSet<>();
		Optional<ClassOfStudent> classOfStudent =  classRepository.findById(classNumber);
		
		if(classOfStudent.isEmpty()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		} else {
			ClassOfStudent returnClass = classOfStudent.get();
			Set<Student> students = returnClass.getStudents();
			
			for (Student student : students) {
				StudentModel stu = new StudentModel();
				stu.setClassNumber(student.getClassOfStudent().getClassNumber());
				stu.setMarks(student.getMarks());
				stu.setName(student.getName());
				stu.setRollNo(student.getRollNo());
				
				studentsToBeReturned.add(stu);
				
			}
			return new ResponseEntity<Set<StudentModel>> (studentsToBeReturned, HttpStatus.OK);
		}

	}catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	}
	
}
