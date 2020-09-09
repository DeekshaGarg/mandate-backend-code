package com.example.restfulservices.model;

public class HelloWorldBean {
	
	private String message;

	//getter is required to convert bean to json otherwise error is thrown
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String message) {
		this.message=message;
	}

}
