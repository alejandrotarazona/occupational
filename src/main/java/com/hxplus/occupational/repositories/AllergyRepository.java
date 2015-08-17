package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Allergy;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long> {

}
