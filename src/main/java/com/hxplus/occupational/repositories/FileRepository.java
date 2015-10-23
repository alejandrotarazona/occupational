package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

	@Query("select r from Exam e join e.results r where e.id = (:idexam)")
	public File findByExamId(@Param("idexam") Long idExam);
	
	public List<File> findByConsultId(Long id);
}
