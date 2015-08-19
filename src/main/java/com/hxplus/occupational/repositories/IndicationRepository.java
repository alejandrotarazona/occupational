package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Indication;

@Repository
public interface IndicationRepository extends JpaRepository<Indication, Long> {

}
