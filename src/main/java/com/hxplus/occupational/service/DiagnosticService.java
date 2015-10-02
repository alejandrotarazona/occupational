package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Diagnostic;
import com.hxplus.occupational.request.DiagnosticRequest;

public interface DiagnosticService {
	
	public Diagnostic findById(Long id);
	public List<Diagnostic> findAll();
	public List<Diagnostic> findByPatientId(Long idPantient);
	public Diagnostic saveDiagnostic(DiagnosticRequest diagnosticRequest);
	public Diagnostic updateDiagnostic(Long id, DiagnosticRequest diagnosticRequest);
	public ResponseEntity<Object> deleteDiagnostic(Long id);

}
