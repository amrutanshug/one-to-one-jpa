package com.practice.model;

public class ClassModel {
	private String school;
	private Integer classNumber;
	private String description;
	
	public ClassModel() {
		
	}
	public ClassModel(Integer classNumber, String description, String school) {
		super();
		this.classNumber = classNumber;
		this.description = description;
		this.school = school;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
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
	@Override
	public String toString() {
		return "ClassModel [classNumber=" + classNumber + ", description=" + description + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classNumber == null) ? 0 : classNumber.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		ClassModel other = (ClassModel) obj;
		if (classNumber == null) {
			if (other.classNumber != null)
				return false;
		} else if (!classNumber.equals(other.classNumber))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	
	
}
