package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Consult;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Long> {

}
