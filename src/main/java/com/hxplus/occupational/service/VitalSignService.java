package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.VitalSign;
import com.hxplus.occupational.request.VitalSignRequest;

public interface VitalSignService {
	
	public VitalSign findById(Long id);
	public List<VitalSign> findAll();
	public List<VitalSign> findByConsultId(Long idConsult);
	public List<VitalSign> findAllNames();
	public VitalSign saveVitalSign(VitalSignRequest vitalSignRequest);
	public VitalSign updateVitalSign(Long id, VitalSignRequest vitalSignRequest);
	public ResponseEntity<Object> deleteVitalSign(Long id);

}
