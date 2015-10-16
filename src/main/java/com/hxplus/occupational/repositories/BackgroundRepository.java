package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Background;

@Repository
public interface BackgroundRepository extends JpaRepository<Background, Long> {
	
	public List<Background> findByPatientId(Long idPatient);

}
