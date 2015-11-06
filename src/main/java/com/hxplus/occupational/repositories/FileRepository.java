package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

	@Query("select r from Exam e join e.results r where e.id = (:idexam)")
	public File findByExamId(@Param("idexam") Long idExam);
	
	//public List<File> findByConsultId(Long id);
	
	public byte[] findDataById(Long id);
	
	@Query("select f.data from User u join u.photo f where u.id = (:iduser)")
	public byte[] findDataByUserId(@Param("iduser") Long userId);
	
	@Query("select f from Exam e join e.results f where e.id = (:idexam)")
	public File findIdByExam(@Param("idexam") Long idExam);
	
	@Query("select f from User u join u.photo f where u.id = (:iduser)")
	public File findIdByUser(@Param("iduser") Long idUser);
	
}
