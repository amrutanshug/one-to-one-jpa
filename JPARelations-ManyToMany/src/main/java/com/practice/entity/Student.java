package com.practice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roll_number")
	private Long rollNo;
	private String name;
	@Column(name = "class")
	private Integer inClass;
	
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn (name = "student_roll_number", insertable = false, updatable = false),
			inverseJoinColumns = @JoinColumn (name = "course_name", insertable = false, updatable = false)
			)
	@JsonIgnore
	private Set<Course> courses;
	
	
	public Student() {
		
	}
	
	public Student(Long rollNo, String name, Integer inClass) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.inClass = inClass;
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
	public Integer getInClass() {
		return inClass;
	}
	public void setInClass(Integer inClass) {
		this.inClass = inClass;
	}
	@JsonIgnore
	public Set<Course> getCourses() {
		return courses;
	}
	@JsonProperty
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
	
}
