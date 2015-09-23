package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	
	@Query("SELECT d FROM Doctor d WHERE d.user.id = (:id)")
	public Doctor findByUser(@Param("id") Long idUser);
	
	@Query("SELECT DISTINCT p.doctors " 
			+ "FROM Patient p "
			+ "JOIN p.doctors as d "
			+ "JOIN p.user as u "
			+ "WHERE p.id = (:id) "
			+ "ORDER BY u.lastName ASC, u.firstName ASC")
	public List<Doctor> listDoctorbyPatient(@Param("id") Long idpatient);

}
