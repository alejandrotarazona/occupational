package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Indication;

@Repository
public interface IndicationRepository extends JpaRepository<Indication, Long> {
	
	@Query("select i from Prescription p join p.indication i where p.id = (:id)")
	public Indication findByPrescriptionId(@Param("id") Long idPrescription);

}
