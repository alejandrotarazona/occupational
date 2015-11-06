package com.hxplus.occupational.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping(value = "file")
public class FileController {
	@Autowired
	FileService fileService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	File getFile(@PathVariable("id") Long id) {
		return fileService.findById(id);
	}
	
	@RequestMapping(value="/exam/{id}", method= RequestMethod.GET)
	public @ResponseBody
	File getIdByExam(@PathVariable("id") Long idExam){
		return fileService.findIdByExam(idExam);
	}

	@RequestMapping(value = "/getImage/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ResponseEntity getImage(@PathVariable("id") Long id) {
		File file = fileService.findById(id);

		if (file == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		HttpHeaders headers = new HttpHeaders();
		headers.add("content-disposition",
				"attachment; filename=" + file.getFileName());

		String primaryType, subType;
		
		try {
			primaryType = file.getType().split("/")[0];
			subType = file.getType().split("/")[1];
		} catch (IndexOutOfBoundsException | NullPointerException ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		headers.setContentType( new MediaType(primaryType, subType) );

        return new ResponseEntity<>(file.getData(), headers, HttpStatus.OK);


	}

	@RequestMapping(value = "/byexam/{id}", method = RequestMethod.GET)
	public @ResponseBody
	File getFileByExam(@PathVariable("id") Long idExam) {
		return fileService.findByExam(idExam);
	}
	
	@RequestMapping(value = "/byuser/{id}", method = RequestMethod.GET)
	public @ResponseBody
	File getFileByUser(@PathVariable("id") Long idUser) {
		return fileService.findByUser(idUser);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<File> getFiles() {
		return fileService.findAll();
	}

//	@RequestMapping(value = "/byconsult/{id}", method = RequestMethod.GET)
//	public @ResponseBody
//	List<File> getFilesByConsult(@PathVariable("id") Long idConsult) {
//		return fileService.findByConsult(idConsult);
//	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	File createFile(@RequestBody FileRequest fileRequest) {
		return fileService.saveFile(fileRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	File updateFile(@PathVariable("id") Long id,
			@RequestBody FileRequest fileRequest) {
		return fileService.updateFile(id, fileRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteFile(@PathVariable("id") Long id) {
		return fileService.deleteFile(id);
	}
}