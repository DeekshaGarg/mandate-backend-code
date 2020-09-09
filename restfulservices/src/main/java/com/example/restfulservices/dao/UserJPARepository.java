package com.example.restfulservices.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restfulservices.model.User;

@Repository
public interface UserJPARepository extends CrudRepository<User, Integer> {

}
