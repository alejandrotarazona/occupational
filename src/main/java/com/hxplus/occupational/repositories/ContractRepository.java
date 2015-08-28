package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
	
	public List<Contract> findByUser(Long userId);
	
}
