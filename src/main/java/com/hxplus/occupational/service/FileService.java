package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.File;
import com.hxplus.occupational.request.FileRequest;

public interface FileService {
	
	public File findById(Long id);
	public List<File> findAll();
	public File saveFile(FileRequest fileRequest);
	public File updateFile(Long id, FileRequest fileRequest);
	public ResponseEntity<Object> deleteFile(Long id);

}
