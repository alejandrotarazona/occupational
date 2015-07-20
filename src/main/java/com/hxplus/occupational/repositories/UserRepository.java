package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
