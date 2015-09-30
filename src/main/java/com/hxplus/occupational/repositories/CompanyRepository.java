package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.model.Post;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Query("select distinct comp "
			+ "from Post p "
			+ "join p.costCenters cost "
			+ "join cost.company comp "
			+ "where p = (:post)")
	public Company findByPost(@Param("post") Post post);
}
