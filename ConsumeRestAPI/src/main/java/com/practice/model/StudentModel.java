package com.practice.model;

public class StudentModel {

	private Long rollNo;
	private String name;
	private Float marks;
	private Integer classNumber;
	
	
	public StudentModel() {
		
	}
	
	public StudentModel(Long rollNo, String name, Float marks, Integer classNumber) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
		this.classNumber = classNumber;
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
	public Integer getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}
	@Override
	public String toString() {
		return "StudentModel [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + ", classNumber=" + classNumber
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classNumber == null) ? 0 : classNumber.hashCode());
		result = prime * result + ((marks == null) ? 0 : marks.hashCode());
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
		StudentModel other = (StudentModel) obj;
		if (classNumber == null) {
			if (other.classNumber != null)
				return false;
		} else if (!classNumber.equals(other.classNumber))
			return false;
		if (marks == null) {
			if (other.marks != null)
				return false;
		} else if (!marks.equals(other.marks))
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
