package com.example.restfulservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restfulservices.dao.PostJPARepository;
import com.example.restfulservices.dao.UserJPARepository;
import com.example.restfulservices.exception.UserNotFoundException;
import com.example.restfulservices.model.Post;
import com.example.restfulservices.model.User;

@RestController
public class UserJPAController {
	
	@Autowired
	private UserJPARepository repository;
	
	@Autowired
	private PostJPARepository postRepository;
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		// Location is added in headers
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/jpa/users")
	public List<User> retriveAllUsers() {
		return (List<User>) repository.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> retriveAllUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found " + id);
		}
		EntityModel<User> resource = EntityModel.of(user.get());

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());

		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retriveAllPosts(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found " + id);
		}
		
		return user.get().getPosts();
	}
	
	@PostMapping(path = "/jpa/users/{userid}/posts")
	public ResponseEntity<Object> createPosts(@PathVariable int userid, @RequestBody Post post) {
		Optional<User> user = repository.findById(userid);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found " + userid);
		}
		
		User user1=user.get();
		post.setUser(user1);
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		// Location is added in headers
		return ResponseEntity.created(location).build();
	}

}
