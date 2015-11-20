package com.hxplus.occupational.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxplus.occupational.request.PDFRequest;
import com.hxplus.occupational.service.DownloadService;

@Controller
@RequestMapping(value="download")
public class PDFController {
	
	@Autowired DownloadService downloadService;
	
	@RequestMapping(value="/inform", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<byte[]> downloadInform(@RequestBody PDFRequest pdfRequest){
		return downloadService.downloadInform(pdfRequest);
	}
	
	@RequestMapping(value="/rest", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<byte[]> downloadRest(@RequestBody PDFRequest pdfRequest){
		return downloadService.downloadRest(pdfRequest);
	}

}
