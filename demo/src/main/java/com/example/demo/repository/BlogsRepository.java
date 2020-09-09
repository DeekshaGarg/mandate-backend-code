package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BlogModel;

@Repository
public interface BlogsRepository extends MongoRepository<BlogModel,String> {

	
}

