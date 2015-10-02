package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hxplus.occupational.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query("select p from User u join u.post p where u.id = (:iduser)")
	public Post findByUser(@Param("iduser") Long idUser);

}
