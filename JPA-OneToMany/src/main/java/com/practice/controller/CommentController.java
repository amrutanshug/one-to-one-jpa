package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Comment;
import com.practice.repository.CommentRepository;


@RestController
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@GetMapping(value = "/getAllComments")
	public List<Comment> getAllComments(){
		return commentRepository.findAll();
	}
	
	@PostMapping(value = "/addComment")
	public void addComment (@RequestBody Comment comment) {
		commentRepository.save(comment);
	}
}
