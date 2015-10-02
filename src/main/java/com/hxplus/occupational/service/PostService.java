package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Post;
import com.hxplus.occupational.request.PostRequest;

public interface PostService {
	
	public Post findById(Long id);
	public List<Post> findAll();
	public Post findByUser(Long user);
	public Post savePost(PostRequest postRequest);
	public Post updatePost(Long id, PostRequest postRequest);
	public ResponseEntity<Object> deletePost(Long id);

}
