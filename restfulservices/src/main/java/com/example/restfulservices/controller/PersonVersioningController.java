package com.example.restfulservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulservices.model.Name;
import com.example.restfulservices.model.PersonV1;
import com.example.restfulservices.model.PersonV2;

@RestController
public class PersonVersioningController {
	
	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Adam Singh");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Adam","Singh"));
	}
	
	@GetMapping(value="/person", params="version=1")
	public PersonV1 personV1withParam() {
		return new PersonV1("Adam Singh");
	}
	
	@GetMapping(value="/person", params="version=2")
	public PersonV2 personV2withParam() {
		return new PersonV2(new Name("Adam","Singh"));
	}
	
	@GetMapping(value="/person", headers="X_API_VERSION=1")
	public PersonV1 personV1withHeader() {
		return new PersonV1("Adam Singh");
	}
	
	@GetMapping(value="/person", headers="X_API_VERSION=2")
	public PersonV2 personV2withHeader() {
		return new PersonV2(new Name("Adam","Singh"));
	}
	
	@GetMapping(value="/person", produces="application/vnd.company.app-v1+json")
	public PersonV1 personV1withProduces() {
		return new PersonV1("Adam Singh");
	}
	
	@GetMapping(value="/person", produces="application/vnd.company.app-v2+json")
	public PersonV2 personV2withProduces() {
		return new PersonV2(new Name("Adam","Singh"));
	}

}
