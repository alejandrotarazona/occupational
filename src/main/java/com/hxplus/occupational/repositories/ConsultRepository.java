package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Consult;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Long> {

	@Query("select c from Consult c join c.patient p where p.id = (:idpatient)")
	public List<Consult> findByPatient(@Param("idpatient") Long idPatient);
	
//	@Query("select c "
//			+ "from Consult c "
//			+ "join c.history h "
//			+ "where h.id = (:id)")
//	public List<Consult> finfAllByIdHistory(@Param("id") Long idHistory);

}
