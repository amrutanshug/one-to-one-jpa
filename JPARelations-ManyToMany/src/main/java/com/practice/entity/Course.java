package com.practice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	
	@Id
	@Column(name = "course_name")
	private String courseName;
	private String description;
	@Column(name = "duration_in_years")
	private Float durationInYears;
	
	@ManyToMany (mappedBy = "courses", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Student> students;
	

	public Course() {
		
	}
	
	public Course(String courseName, String description, Float durationInYears, Set<Student> students) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.durationInYears = durationInYears;
		this.students = students;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getDurationInYears() {
		return durationInYears;
	}
	public void setDurationInYears(Float durationInYears) {
		this.durationInYears = durationInYears;
	}
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
