package com.example.restfulservices.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulservices.model.SomeBean;
import com.example.restfulservices.model.SomeBeanforDynamicFiltering;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import static com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.filterOutAllExcept;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("val1","val2","val3");
	}
	
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retrieveSomeBeanforDynamicFiltering() {
		SomeBeanforDynamicFiltering bean= new SomeBeanforDynamicFiltering("val1","val2","val3");
		MappingJacksonValue mapping=new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		
		mapping.setFilters(filters);
		
		return mapping;
	}

}
