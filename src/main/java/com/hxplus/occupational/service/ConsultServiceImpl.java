package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.repositories.ConsultRepository;
import com.hxplus.occupational.request.ConsultRequest;

public class ConsultServiceImpl implements ConsultService {

	@Autowired ConsultRepository consultRepository;

	@Override
	public Consult findById(Long id) {
		return consultRepository.findOne(id);
	}

	@Override
	public List<Consult> findAll() {
		return consultRepository.findAll();
	}

	@Override
	public Consult saveConsult(ConsultRequest consultRequest) {
		return consultRepository.save(fromReq(new Consult(), consultRequest));
	}

	@Override
	public Consult updateConsult(Long id, ConsultRequest consultRequest) {
		return consultRepository.save(fromReq(findById(id), consultRequest));
	}

	@Override
	public ResponseEntity<Object> deleteConsult(Long id) {
		try{
			consultRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Consult fromReq(Consult consult, ConsultRequest consultRequest){
		consult.setConsultDate(consultRequest.getConsultDate());
		consult.setDiagnostic(consultRequest.getDiagnostics());
		consult.setDoctor(consultRequest.getDoctor());
		consult.setFile(consultRequest.getFiles());
		consult.setInstruction(consultRequest.getInstructions());
		consult.setPrescription(consultRequest.getPrescription());
		consult.setRecieveExam(consultRequest.getRecieveExams());
		consult.setRequestExam(consultRequest.getRequestExams());
		consult.setSoapNote(consultRequest.getSoapNote());
		consult.setVitalSigns(consultRequest.getVitalSigns());
		
		return consult;	}

}
