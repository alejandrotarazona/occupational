package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hxplus.occupational.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
