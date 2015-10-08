package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.VitalSign;
import com.hxplus.occupational.repositories.VitalSignRepository;
import com.hxplus.occupational.request.VitalSignRequest;
@Service
public class VitalSignServiceImpl implements VitalSignService {

	@Autowired VitalSignRepository vitalSignrepository;
	
	@Override
	public VitalSign findById(Long id) {
		return vitalSignrepository.findOne(id);
	}

	@Override
	public List<VitalSign> findAll() {
		return vitalSignrepository.findAll();
	}

	
	
	@Override
	public List<VitalSign> findAllNames() {
		return vitalSignrepository.findAllNames();
	}

	@Override
	public VitalSign saveVitalSign(VitalSignRequest vitalSignRequest) {
		return vitalSignrepository.save(fromReq(new VitalSign(), vitalSignRequest));
	}

	@Override
	public VitalSign updateVitalSign(Long id, VitalSignRequest vitalSignRequest) {
		return vitalSignrepository.save(fromReq(findById(id), vitalSignRequest));
	}

	@Override
	public ResponseEntity<Object> deleteVitalSign(Long id) {
		try{
			vitalSignrepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private VitalSign fromReq(VitalSign vitalSign, VitalSignRequest vitalSignRequest){
		vitalSign.setConsult(vitalSignRequest.getConsult());
		vitalSign.setDescripion(vitalSignRequest.getDescripion());
		vitalSign.setName(vitalSignRequest.getName());
		return vitalSign;
	}

}
