package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Exam;
import com.hxplus.occupational.repositories.ExamRepository;
import com.hxplus.occupational.request.ExamRequest;
@Service
public class ExamServiceImpl implements ExamService {
	
	@Autowired ExamRepository examRepository;

	@Override
	public Exam findById(Long id) {
		return examRepository.findOne(id);
	}

	@Override
	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	@Override
	public Exam saveExam(ExamRequest examRequest) {
		return examRepository.save(fromReq(new Exam(), examRequest));
	}

	@Override
	public Exam updateExam(Long id, ExamRequest examRequest) {
		return examRepository.save(fromReq(findById(id), examRequest));
	}

	@Override
	public ResponseEntity<Object> deleteExam(Long id) {
		try{
			examRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Exam fromReq(Exam exam, ExamRequest examRequest){
		exam.setOrdered(examRequest.getOrdered());
		exam.setReceived(examRequest.getReceived());
		exam.setResults(examRequest.getResults());
		exam.setType(examRequest.getType());
		return exam;
	}

}
