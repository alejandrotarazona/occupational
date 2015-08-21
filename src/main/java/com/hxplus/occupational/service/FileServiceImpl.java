package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.File;
import com.hxplus.occupational.repositories.FileRepository;
import com.hxplus.occupational.request.FileRequest;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	FileRepository fileRepository;

	@Override
	public File findById(Long id) {
		return fileRepository.findOne(id);
	}

	@Override
	public List<File> findAll() {
		return fileRepository.findAll();
	}

	@Override
	public File saveFile(FileRequest fileRequest) {
		return fileRepository.save(fromReq(new File(), fileRequest));
	}

	@Override
	public File updateFile(Long id, FileRequest fileRequest) {
		return fileRepository.save(fromReq(findById(id), fileRequest));
	}

	@Override
	public ResponseEntity<Object> deleteFile(Long id) {
		try {
			fileRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private File fromReq(File file, FileRequest fileRequest) {
		file.setConsult(fileRequest.getConsult());
		file.setFile(fileRequest.getFile());
		file.setFileName(fileRequest.getFileName());
		return file;
	}

}
