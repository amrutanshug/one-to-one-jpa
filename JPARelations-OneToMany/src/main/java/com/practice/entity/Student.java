package com.practice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rollNo;
	private String name;
	private Float marks;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_number", referencedColumnName = "classNumber", insertable = true, updatable = true, nullable = false)
	private ClassOfStudent classOfStudent;
	
	public Student() {
		
	}
	public Student(String name, Float marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	
	public ClassOfStudent getClassOfStudent() {
		return classOfStudent;
	}
	public void setClassOfStudent(ClassOfStudent classOfStudent) {
		this.classOfStudent = classOfStudent;
	}
	public Long getRollNo() {
		return rollNo;
	}
	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getMarks() {
		return marks;
	}
	public void setMarks(Float marks) {
		this.marks = marks;
	}
	
	
}
