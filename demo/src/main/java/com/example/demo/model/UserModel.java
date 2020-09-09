package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("loginUser")
public class UserModel {
	
	@Id
	private String loginid;
	private String username;
	private String password;
	private String confirmpass;
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getConfirmpass() {
		return confirmpass;
	}
	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
