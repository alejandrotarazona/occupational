package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.User;
import com.hxplus.occupational.repositories.UserRepository;
import com.hxplus.occupational.request.UserRequest;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserRepository userRepository;
	
	public User findById(Long id) {
		return userRepository.findOne(id);
	}
	
	private User fromReq(User user, UserRequest userRequest){
		user.setCi(userRequest.getCi());
		user.setRif(userRequest.getRif());
		user.setAddress(userRequest.getDireccionHabitacion());
		user.setEmail(userRequest.getEmail());
		user.setFirstName(userRequest.getPrimerNombre());
		user.setLastName(userRequest.getPrimerApellido());
		user.setPhoneNumber(userRequest.getNroTelefono());
		
		return user;
	}
	
	public User saveUser(UserRequest userRequest){
		User user = fromReq(new User(), userRequest);		
		userRepository.save(user);
		return user;
	}
	
	public User createUser(User user){
		user.setFirstName("Alejandro");
		user.setLastName("Tarazona");
		user.setEmail("alejandrotarazona@gmail.com");
		user.setPhoneNumber("04121341842");
		return user;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Long id, UserRequest userRequest) {
		return userRepository.save(fromReq(findById(id),userRequest));						
	}

	@Override
	public ResponseEntity<Object> deleteUser(Long id) {
		try{
			userRepository.delete(id);
			return new ResponseEntity<Object>(null,HttpStatus.OK);
		}catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
