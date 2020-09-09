package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserLoginRepository;
import com.example.demo.service.UserService;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserLoginRepository loginRepo;
	
	public UserModel getUsers(String loginId) throws ResourceNotFoundException{
		UserModel user= loginRepo.findById(loginId).orElseThrow(()-> new ResourceNotFoundException("User not found "+loginId));
		return user;
	}
	
	/*
	 * public UserModel findUser(String loginId) throws ResourceNotFoundException{
	 * UserModel user= loginRepo.findById(loginId).orElseThrow(()-> new
	 * ResourceNotFoundException("User not found "+loginId)); return user; }
	 */
	
	public UserModel createUser(UserModel user) {
		return loginRepo.save(user);
	}
	
	public List<UserModel> getUsers(){
		return loginRepo.findAll();
	}

	@Override
	public UserModel findByIdAndPassUserModel(String id, String pass) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * public UserModel findByIdAndPassUserModel(String id, String pass) throws
	 * ResourceNotFoundException { UserModel user=
	 * loginRepo.findByLoginidAndPassword(id, pass).orElseThrow(()-> new
	 * ResourceNotFoundException("User not found "+id)); return user; }
	 */
	
	

}
