package com.first.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.first.demo.controller"})
public class BloggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggingApplication.class, args);
	}
 
}
