package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}
