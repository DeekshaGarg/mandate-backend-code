package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.UserModel;

public interface UserLoginRepository extends MongoRepository<UserModel, String>{

	//public Optional<UserModel> findByLoginidAndPassword(String id, String pass);
	
}
