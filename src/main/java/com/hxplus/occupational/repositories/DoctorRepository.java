package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	@Query("SELECT d FROM Doctor d JOIN FETCH d.patients WHERE d.id = (:id)")
	public Doctor findByIdAndFetchPatientsEagerly(@Param("id") Long id);
	
	@Query("SELECT d FROM Doctor d WHERE d.user.id = (:id)")
	public Doctor findByUser(@Param("id") Long idUser);
	
	/*@Query("INSERT INTO Doctor (id,regnumber) SELECT u.id FROM User u WHERE u.id = (:id)")
	public Doctor saveWithUser(@Param("id") Long id, @Param("regnumber") Long regNumber);*/

}
