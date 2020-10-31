package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.Comment;
//Comment added
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
}
