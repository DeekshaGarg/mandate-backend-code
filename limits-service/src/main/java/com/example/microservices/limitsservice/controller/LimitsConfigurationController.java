package com.example.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limitsservice.Configuration;
import com.example.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		//return new LimitConfiguration(1,1000);
		return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
	}
	
	@GetMapping("/limits-hystrix-fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveLimits")
	public LimitConfiguration retrieveLimits() {
		//return new LimitConfiguration(1,1000);
		throw new RuntimeException("Exception occured");
	}
	
	public LimitConfiguration fallbackRetrieveLimits() {
		//return new LimitConfiguration(1,1000);
		return new LimitConfiguration(0,1);
	}

}
