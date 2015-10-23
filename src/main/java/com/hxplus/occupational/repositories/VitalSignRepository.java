package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.VitalSign;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSign, Long> {

	public List<VitalSign> findByConsultId(Long idConsult);
	
	@Query("select distinct vs.name from VitalSign vs")
	public List<VitalSign> findAllNames();
}
