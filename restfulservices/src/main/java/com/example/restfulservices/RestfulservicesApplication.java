package com.example.restfulservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class RestfulservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulservicesApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver localeResolver=new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	//You can do this config in application.properties
	/*
	 * @Bean public ResourceBundleMessageSource messageSource() {
	 * ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
	 * messageSource.setBasename("message"); return messageSource; }
	 */

}
