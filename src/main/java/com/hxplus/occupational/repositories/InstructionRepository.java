package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Instruction;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {

	public List<Instruction> findByConsultId(Long idConsult);
	
}
