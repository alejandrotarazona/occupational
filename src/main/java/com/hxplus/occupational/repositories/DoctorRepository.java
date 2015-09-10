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
			//+ "JOIN User as u "
			+ "WHERE p.id = (:id) "
			//+ "AND pu.id = u.id "
			+ "ORDER BY u.lastName ASC, u.firstName ASC")
	public List<Doctor> listDoctorbyPatient(@Param("id") Long idpatient);
//	
//	@Query("SELECT DISTINCT d.patients " 
//			+ "FROM Doctor d "
//			+ "JOIN FETCH d.patients p "
//			+ "JOIN p.user u "
//			+ "WHERE d.id = (:id) "
//			+ "ORDER BY u.lastName ASC, u.firstName ASC")
//	public List<Patient> listPatientsByDoctor(@Param("id") Long iddoctor);
	
	/*@Query("INSERT INTO Doctor (id,regnumber) SELECT u.id FROM User u WHERE u.id = (:id)")
	public Doctor saveWithUser(@Param("id") Long id, @Param("regnumber") Long regNumber);*/

}
