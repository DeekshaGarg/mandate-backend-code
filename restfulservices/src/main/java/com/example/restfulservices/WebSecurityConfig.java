	package com.example.restfulservices;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableOAuth2Sso
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	    @Override
	    protected void configure(HttpSecurity http) throws Exception{
	        http.cors().and().csrf().disable()
	        .authorizeRequests().antMatchers("/login").permitAll()
	        .anyRequest().authenticated()
	        .and().httpBasic();
	    }
}
