package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BlogModel;
import com.example.demo.repository.BlogsRepository;

@RestController
public class BlogController {

	@Autowired
	@Lazy
	private BlogsRepository blogRepo;
	
	@GetMapping("/blog/findAll")
	public List<BlogModel> findAllBlogs() {
		return blogRepo.findAll();
		
	}
	
	@PostMapping("/blog/create")
	public BlogModel createBlog(@RequestBody BlogModel blog) {
		return blogRepo.save(blog);
	}
}
