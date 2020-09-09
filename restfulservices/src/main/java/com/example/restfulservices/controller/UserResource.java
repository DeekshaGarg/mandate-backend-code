package com.example.restfulservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restfulservices.dao.UserDaoService;
import com.example.restfulservices.exception.UserNotFoundException;
import com.example.restfulservices.model.User;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	//var name messageSource should be same as bean method created in main class
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/good-morning-internationalization")
	public String goodMorning(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message",null, locale);
	}
	
	
	//it is headache to pass locale in header of each request, so we can get it from LocaleContextHolder
	@GetMapping("/good-morning-internationalization-without-header")
	public String goodMorningFromLocaleContext() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}

	@GetMapping(path = "/users")
	public List<User> retriveAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retriveAllUser(@PathVariable int id) {
		User user = userDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("User not found " + id);
		}
		
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers

		EntityModel<User> resource = EntityModel.of(user);

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());

		resource.add(linkTo.withRel("all-users"));

		//spring < 2.2.0
		/*
		 * Resource<User> resource= new Resource<User>(user); ControllerLinkBuilder
		 * linkTo= linkTo(methodOn(this.getClass()).retriveAllUsers());
		 */
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		// Location is added in headers
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id " + id);
		}
		userDaoService.deleteById(id);
	}

}
