package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
