package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Exam;
import com.hxplus.occupational.request.ExamRequest;

public interface ExamService {

	public Exam findById(Long id);
	public List<Exam> findAll();
	public Exam saveExam(ExamRequest examRequest);
	public Exam updateExam(Long id, ExamRequest examRequest);
	public ResponseEntity<Object> deleteExam(Long id);

}
