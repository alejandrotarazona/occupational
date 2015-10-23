package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

	@Query("select e "
			+ "from Patient p "
			+ "join p.consults c "
			+ "join c.requestExams e "
			+ "where p.id = (:idpatient) "
			+ "and e not in "
			+ "(select r "
			+ "from Patient pa "
			+ "join pa.consults co "
			+ "join co.recieveExams r "
			+ "where pa.id=(:idpatient))")
	public List<Exam> findPendingByPatientId(@Param("idpatient") Long idPatient);
	
	public List<Exam> findByOrdered(Consult consult);
	
	public List<Exam> findByReceived(Consult consult);
	
}
