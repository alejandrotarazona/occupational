package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

}
