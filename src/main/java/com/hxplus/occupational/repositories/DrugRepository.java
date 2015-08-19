package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

}
