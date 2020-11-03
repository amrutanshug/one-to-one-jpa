package com.practice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "update student set class_number= :classNum where roll_no>= :range", nativeQuery = true)
	public void assignClassesToStudent(@Param("classNum") Integer classNum, @Param("range") Long range);
	
	
	@Modifying
	@Transactional
	@Query("update Student c set c.classOfStudent.classNumber= :classNum where c.rollNo>= :range")
	public void assignClassesToStudentUsingJPQL(@Param("classNum") Integer classNum, @Param("range") Long range);

}
