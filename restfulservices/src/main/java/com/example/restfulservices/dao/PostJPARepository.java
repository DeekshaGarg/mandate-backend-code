package com.example.restfulservices.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restfulservices.model.Post;

@Repository
public interface PostJPARepository extends CrudRepository<Post, Integer>{

}
