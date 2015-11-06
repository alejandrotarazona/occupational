package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.File;
import com.hxplus.occupational.request.FileRequest;

public interface FileService {
	
	public File findById(Long id);
	public File findIdByExam(Long idExam);
	public byte[] findDataByUser(Long idUser);
	public byte[] findFileById(Long id);
	public File findByExam(Long idExam);
	public File findByUser(Long idUser);
	public List<File> findAll();
	public File saveFile(FileRequest fileRequest);
	public File updateFile(Long id, FileRequest fileRequest);
	public ResponseEntity<Object> deleteFile(Long id);

}
