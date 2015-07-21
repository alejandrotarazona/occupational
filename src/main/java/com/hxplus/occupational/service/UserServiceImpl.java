package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		user.setDireccionHabitacion(userRequest.getDireccionHabitacion());
		user.setEmail(userRequest.getEmail());
		user.setPrimerNombre(userRequest.getPrimerNombre());
		user.setPrimerApellido(userRequest.getPrimerApellido());
		user.setNroTelefono(userRequest.getNroTelefono());
		
		return user;
	}
	
	public User saveUser(UserRequest userRequest){
		User user = fromReq(new User(), userRequest);		
		userRepository.save(user);
		return user;
	}
	
	public User createUser(User user){
		user.setPrimerNombre("Alejandro");
		user.setPrimerApellido("Tarazona");
		user.setEmail("alejandrotarazona@gmail.com");
		user.setNroTelefono("04121341842");
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
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}
	
	
}
