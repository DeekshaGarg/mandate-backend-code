package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UserModel;

@Service
public interface UserService {

	public UserModel getUsers(String loginId) throws ResourceNotFoundException;

	public UserModel createUser(UserModel user);
	
	public List<UserModel> getUsers();
	
	public UserModel findByIdAndPassUserModel(String id, String pass) throws ResourceNotFoundException;
}
