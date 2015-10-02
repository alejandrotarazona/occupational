package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Diagnostic;

@Repository
public interface DiagnosticRepository extends JpaRepository<Diagnostic, Long> {

	@Query("select d "
			+ "from Patient p "
			+ "join p.history h "
			+ "join h.consults c "
			+ "join c.diagnostics d "
			+ "where p.id = (:idpatient) ")
	public List<Diagnostic> findByPatientId(@Param("idpatient") Long patientId);
}
