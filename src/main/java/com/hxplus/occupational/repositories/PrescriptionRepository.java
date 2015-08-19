package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Prescription;

@Repository
public interface PrescriptionRepository extends
		JpaRepository<Prescription, Long> {

}
