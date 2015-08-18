package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.History;
import com.hxplus.occupational.request.HistoryRequest;

public interface HistoryService {
	public History findById(Long id);
	public List<History> findAll();
	public History saveHistory(HistoryRequest historyRequest);
	public History updateHistory(Long id, HistoryRequest historyRequest);
	public ResponseEntity<Object> deleteHistory(Long id);
}
