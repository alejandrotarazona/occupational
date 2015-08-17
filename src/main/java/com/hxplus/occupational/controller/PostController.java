package com.hxplus.occupational.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxplus.occupational.model.Post;
import com.hxplus.occupational.request.PostRequest;
import com.hxplus.occupational.service.PostService;

@Controller
@RequestMapping(value = "/post")
public class PostController {
	
	@Autowired PostService postService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Post getPost(@PathVariable("id") Long id){
		return postService.findById(id);
	}
	
	@RequestMapping(value="",method= RequestMethod.GET)
	public @ResponseBody List<Post> getPosts(){
		return postService.findAll();
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public @ResponseBody Post createPost(@RequestBody PostRequest postRequest){
		return postService.savePost(postRequest);		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Post updatePost(@PathVariable("id") Long id, @RequestBody PostRequest postRequest){
		return postService.updatePost(id, postRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deletePost(@PathVariable("id") Long id){
		return postService.deletePost(id);
	}
}
