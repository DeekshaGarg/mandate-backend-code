package com.example.restfulservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.restfulservices.model.User;

@Component
public class UserDaoService {

	private static List<User> users=new ArrayList<>();
	
	static {
		users.add(new User(1,"Adam",new Date()));
		users.add(new User(2,"Eve",new Date()));
		users.add(new User(3,"Jack",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				 return user;
			}
		}
		return null;
	}
	
	public void deleteById(int id) {
		Iterator<User> itr=users.iterator();
		while(itr.hasNext()) {
			User user=itr.next();
			if(user.getId()==id) {
				users.remove(user);
				break;
			}
		}
	}
}
