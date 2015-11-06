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
	public File findIdByExam(Long idExam) {
		File file = fileRepository.findIdByExam(idExam);
		file.setData(null);
		file.setFileName(null);
		file.setType(null);
		return file;
	}
	
	@Override
	public byte[] findDataByUser(Long idUser) {
		return fileRepository.findDataByUserId(idUser);
	}

	@Override
	public byte[] findFileById(Long id) {
		return fileRepository.findDataById(id);
	}

	@Override
	public File findByExam(Long idExam) {
		return fileRepository.findByExamId(idExam);
	}
	
	

	@Override
	public File findByUser(Long idUser) {
		File file = fileRepository.findIdByUser(idUser);
		file.setData(null);
		file.setFileName(null);
		file.setType(null);
		return file;
	}

	@Override
	public List<File> findAll() {
		return fileRepository.findAll();
	}

//	@Override
//	public List<File> findByConsult(Long idConsult) {
//		return fileRepository.findByConsultId(idConsult);
//	}

	@Override
	public File saveFile(FileRequest fileRequest) {
		return fileRepository.save(fromReq(new File(), fileRequest));
	}

	@Override
	public File updateFile(Long id, FileRequest fileRequest) {
		return fileRepository.save(fromReq(fileRepository.findOne(id),
				fileRequest));
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
		file.setData(fileRequest.getData());
		file.setFileName(fileRequest.getFileName());
		file.setType(fileRequest.getType());
		return file;
	}

	private void printByteArray(byte[] bytes) {
		String hex = "";
		int index = 0;

		for (byte b : bytes) {
			hex = Integer.toHexString(0xFF & b);
			System.out.print(Integer.parseInt(hex, 16));
			index++;
			if (index % 24 == 0)
				System.out.println("");
			else
				System.out.print(",");
		}
	}
}
