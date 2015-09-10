package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	@Query("SELECT p FROM Patient p INNER JOIN p.user u WHERE u.id = (:id)")
	public Patient findByUser(@Param("id") Long idUser);

	@Query("SELECT DISTINCT d.patients " 
			+ "FROM Doctor as d "
			+ "JOIN d.patients as p "
			+ "JOIN p.user as u "
			//+ "JOIN User as u "
			+ "WHERE d.id = (:id) "
			//+ "AND pu.id = u.id "
			+ "ORDER BY u.lastName ASC, u.firstName ASC")
	public List<Patient> listPatientsByDoctor(@Param("id") Long iddoctor);

}
