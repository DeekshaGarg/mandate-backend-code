package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.LoginModel;
import com.example.demo.model.ResponseModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	
	  @Autowired private PasswordEncoder encoder;
	 
	
	@PostMapping("user/create")
	public UserModel createUser(@RequestBody UserModel user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userService.createUser(user);
	}
	
	@GetMapping("user/find")
	public List<UserModel> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("user/basicauth")
	public List<UserModel> getBasicAuth(){
		return userService.getUsers();
	}
	
	@GetMapping("user/find/{loginId}")
	public UserModel getUsers(@PathVariable String loginId) throws ResourceNotFoundException{
		UserModel user= userService.getUsers(loginId);
		return user;
	}
	
	@PostMapping("user/login")
	public ResponseModel loginUser(@RequestBody LoginModel loginDetails) {
		ResponseModel response=new ResponseModel(new Date(), "", "");
		String loginId="";
		try {
			System.out.println("============================");
			System.out.println(loginDetails.getPassword());
			UserModel user= userService.findByIdAndPassUserModel(loginDetails.getLoginid(),loginDetails.getPassword());
			loginId=user.getLoginid();
			response.setstatus("loginSuccess");
			response.setMessage("Login successful for user: "+loginId);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setstatus("loginFailure");
			response.setMessage("Login failed as user not found for user: "+loginDetails.getLoginid());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setstatus("loginFailure");
			response.setMessage("Login failed for user:"+loginDetails.getLoginid());
		}
		return response;
	}
	
	
}
	