package com.hxplus.occupational.service;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.request.PDFRequest;

public interface DownloadService {
	
	public ResponseEntity<byte[]> downloadInform(PDFRequest consult);
	public ResponseEntity<byte[]> downloadRest(PDFRequest pdfRequest);

}
