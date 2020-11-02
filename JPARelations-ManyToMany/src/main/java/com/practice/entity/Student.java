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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roll_number")
	private Long rollNo;
	private String name;
	@Column(name = "class")
	private Integer inClass;
	
	@ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn (name = "student_roll_number", insertable = true, updatable = true),
			inverseJoinColumns = @JoinColumn (name = "course_name")
			)
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

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", inClass=" + inClass + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inClass == null) ? 0 : inClass.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rollNo == null) ? 0 : rollNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (inClass == null) {
			if (other.inClass != null)
				return false;
		} else if (!inClass.equals(other.inClass))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNo == null) {
			if (other.rollNo != null)
				return false;
		} else if (!rollNo.equals(other.rollNo))
			return false;
		return true;
	}
	
}
