package com.practice.model;


public class CourseModel {
	private String courseName;
	private String description;
	private Float durationInYears;
	
	public CourseModel() {
		
	}
	
	public CourseModel(String courseName, String description, Float durationInYears) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.durationInYears = durationInYears;
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
	@Override
	public String toString() {
		return "CourseModel [courseName=" + courseName + ", description=" + description + ", durationInYears="
				+ durationInYears + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((durationInYears == null) ? 0 : durationInYears.hashCode());
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
		CourseModel other = (CourseModel) obj;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (durationInYears == null) {
			if (other.durationInYears != null)
				return false;
		} else if (!durationInYears.equals(other.durationInYears))
			return false;
		return true;
	}
	
	
}
