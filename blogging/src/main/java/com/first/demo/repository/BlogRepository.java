package com.first.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.first.demo.model.BlogData;
import com.first.demo.model.UserData;

@Repository
public interface BlogRepository extends MongoRepository<BlogData,String> {
	//User findByUserName(String userName);
	
	/*
	 * @Query(value = "{'user.userName': ?0}", fields = "{'employees' : 0}") Blog
	 * findBlogByUserName(String userName);
	 */

}
