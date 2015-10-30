package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import com.hxplus.occupational.model.File;
import com.hxplus.occupational.repositories.FileRepository;
import com.hxplus.occupational.request.FileRequest;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	FileRepository fileRepository;

	@Override
	public byte[] findById(Long id) {
		byte[] bs = SerializationUtils.serialize(fileRepository.findOne(id));
		
		System.out.println("Byte Array:");
		System.out.println(bs);
		
		return bs;
	}

	@Override
	public File findByExam(Long idExam) {
		return fileRepository.findByExamId(idExam);
	}

	@Override
	public List<File> findAll() {
		return fileRepository.findAll();
	}

	@Override
	public List<File> findByConsult(Long idConsult) {
		return fileRepository.findByConsultId(idConsult);
	}

	@Override
	public File saveFile(FileRequest fileRequest) {
		File file = fromReq(new File(), fileRequest);
		String path = "/home/atarazona/Documents/eclipse/",
				absPath = file.getFile().getAbsolutePath(),
				newPath = absPath.replace(path, "");
		
		
		return fileRepository.save(file);
	}

	@Override
	public File updateFile(Long id, FileRequest fileRequest) {		
		return fileRepository.save(fromReq(fileRepository.findOne(id), fileRequest));
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
		file.setType(fileRequest.getType());
		return file;
	}

}
