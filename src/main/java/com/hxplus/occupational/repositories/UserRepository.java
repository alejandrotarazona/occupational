package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsernameAndPassword(String username, String password);
	
	@Query("select u from Patient p join p.user u where p.id = (:idpatient)")
	public User findByIdPatient(@Param("idpatient") Long idpatient);
	
	@Query("select u from User u where u.id not in ( select p.user.id from Patient p)")
	public List<User> listNoPatients();

}
