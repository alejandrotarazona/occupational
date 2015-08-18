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

import com.hxplus.occupational.model.File;
import com.hxplus.occupational.request.FileRequest;
import com.hxplus.occupational.service.FileService;

@Controller
@RequestMapping(value="file")
public class FileController {
	@Autowired FileService fileService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody File getFile(@PathVariable("id") Long id){
		return fileService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<File> getFiles(){
		return fileService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody File createFile(@RequestBody FileRequest fileRequest){
		return fileService.saveFile(fileRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody File updateFile(@PathVariable("id") Long id, @RequestBody FileRequest fileRequest){
		return fileService.updateFile(id, fileRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteFile(@PathVariable("id") Long id){
		return fileService.deleteFile(id);
	}
}