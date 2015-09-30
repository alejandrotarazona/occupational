package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Post;
import com.hxplus.occupational.repositories.PostRepository;
import com.hxplus.occupational.request.PostRequest;
@Service
public class PostServiceImpl implements PostService {

	@Autowired PostRepository postRepository;
	
	@Override
	public Post findById(Long id) {
		return postRepository.findOne(id);
	}

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post savePost(PostRequest postRequest) {
		return postRepository.save(fromReq(new Post(), postRequest));
	}

	@Override
	public Post updatePost(Long id, PostRequest postRequest) {
		return postRepository.save(fromReq(findById(id), postRequest));
	}

	@Override
	public ResponseEntity<Object> deletePost(Long id) {
		try{
			postRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Post fromReq(Post post, PostRequest postRequest){
		if(postRequest.getId() != null) post.setId(postRequest.getId());
		post.setDescription(postRequest.getDescription());
		post.setName(postRequest.getName());
		post.setDepartment(postRequest.getDepartment());
		return post;
	}

}
