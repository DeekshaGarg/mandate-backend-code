package com.example.demo.model;

import org.springframework.stereotype.Component;


public class LoginModel {
	
	private String loginid;
	private String password;
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
