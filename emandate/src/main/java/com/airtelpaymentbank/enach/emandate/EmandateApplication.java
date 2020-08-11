package com.airtelpaymentbank.enach.emandate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients("com.airtelpaymentbank.enach.emandate")
public class EmandateApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmandateApplication.class, args);
	}
}
