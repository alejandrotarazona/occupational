package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Allergy;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long> {
	
	public List<Allergy> findByPatientId(Long idPatient);

}
