package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.model.CostCenter;
import com.hxplus.occupational.model.Post;
import com.hxplus.occupational.model.User;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long>{
	
	@Query("select c from CostCenter c where c.company = (:company)")
	public List<CostCenter> findByCompany(@Param("company") Company company);
	
	@Query("select c from Post p join p.costCenters c where p = (:post)")
	public List<CostCenter> findByPost(@Param("post") Post post);
	
	@Query("select c from User u join user.works c where u = (:user)")
	public CostCenter findByUser(@Param("user") User user);

}
