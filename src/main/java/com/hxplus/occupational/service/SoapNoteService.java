package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.SoapNote;
import com.hxplus.occupational.request.SoapNoteRequest;

public interface SoapNoteService {
	
	public SoapNote findById(Long id);
	public List<SoapNote> findAll();
	public SoapNote saveSoapNote(SoapNoteRequest soapNoteRequest);
	public SoapNote updateSoapNote(Long id, SoapNoteRequest soapNoteRequest);
	public ResponseEntity<Object> deleteSoapNote(Long id);

}
