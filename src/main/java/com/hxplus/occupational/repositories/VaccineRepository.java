package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

}
