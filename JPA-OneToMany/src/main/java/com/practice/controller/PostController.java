package com.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Comment;
import com.practice.entity.Post;
import com.practice.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping(value = "/getAllPosts")
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	@PostMapping(value = "/addPost")
	public void addPost (@RequestBody Post post) {
		postRepository.save(post);
	}
	
	@GetMapping(value = "/getPost/{id}/comments")
	public List<Comment> getCommentByPostId(@PathVariable Long id){
		Optional<Post> post = postRepository.findById(id);
		return null;
	}
	
}
