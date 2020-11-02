package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.ClassOfStudent;

@Repository
public interface ClassRepository extends JpaRepository<ClassOfStudent, Integer> {

}
