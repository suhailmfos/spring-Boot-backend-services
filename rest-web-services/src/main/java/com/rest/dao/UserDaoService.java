package com.rest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.model.User;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<User>();
	// input = details of a user
	// output - CREATED & Return the created URI
	private static int countUser = 1445383;
	static {
		users.add(new User(101, "Suhail", new Date()));
		users.add(new User(102, "Mahi", new Date()));
		users.add(new User(103, "Ranga", new Date()));
	}
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++countUser);
		}
		users.add(user);
		return user;
	}
	public List<User> findAll() {
		return users;
	}
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
		
	}
	
	
	// delete user by id
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}













