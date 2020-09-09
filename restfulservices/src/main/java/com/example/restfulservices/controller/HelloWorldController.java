package com.example.restfulservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulservices.model.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	//	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello world";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world  bean");
	}

}
