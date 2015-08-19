package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Instruction;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {

}
