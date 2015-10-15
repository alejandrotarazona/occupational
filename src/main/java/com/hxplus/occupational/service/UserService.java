package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.User;
import com.hxplus.occupational.request.UserRequest;

public interface UserService {

	public User findById(Long id);
	public User fingByPatientId(Long idpatient);
	public List<User> findAll();
	public List<User> listNoPatients();
	public User saveUser(UserRequest userRequest);
	public User createUser(User user);
	public User updateUser(Long id, UserRequest userRequest);
	public ResponseEntity<Object> deleteUser(Long id);
}
