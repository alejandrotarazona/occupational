package com.hxplus.occupational.service;

import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.User;

@Service
public class UserServiceImpl implements UserService{

	public User getUser() {
		User user = new User();			// TODO Auto-generated method stub
		user.setFirstName("Alejandro");
		user.setLastName("Tarazona");
		user.setEmail("alejandro@mail.com");
		return user;
	}
}
