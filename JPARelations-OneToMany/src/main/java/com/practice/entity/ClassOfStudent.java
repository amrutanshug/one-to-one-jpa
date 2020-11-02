package com.practice.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Class")
public class ClassOfStudent {
	
	@Id
	private Integer classNumber;
	private String description;
	
	@OneToMany(mappedBy = "classOfStudent")
	private Set<Student> students;
	
	public ClassOfStudent() {
		
	}
	
	@Column(name = "school_name")
	private String school;
	
	public ClassOfStudent(Integer classNumber, String description, String school) {
		super();
		this.school = school;
		this.classNumber = classNumber;
		this.description = description;
	}
	
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Integer getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
