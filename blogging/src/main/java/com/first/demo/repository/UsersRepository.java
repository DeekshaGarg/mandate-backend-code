package com.first.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.first.demo.model.UserData;

@Repository
public interface UsersRepository extends MongoRepository<UserData, String> {
	UserData findByName(String userName);

}
