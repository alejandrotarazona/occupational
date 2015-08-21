package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.History;
import com.hxplus.occupational.repositories.HistoryRepository;
import com.hxplus.occupational.request.HistoryRequest;
@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired HistoryRepository historyRepository;

	@Override
	public History findById(Long id) {
		return historyRepository.findOne(id);
	}

	@Override
	public List<History> findAll() {
		return historyRepository.findAll();
	}

	@Override
	public History saveHistory(HistoryRequest historyRequest) {
		return historyRepository.save(fromReq(new History(), historyRequest));
	}

	@Override
	public History updateHistory(Long id, HistoryRequest historyRequest) {
		return historyRepository.save(fromReq(findById(id), historyRequest));
	}

	@Override
	public ResponseEntity<Object> deleteHistory(Long id) {
		try{
			historyRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) { 
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private History fromReq(History history, HistoryRequest historyRequest){
		history.setAllergies(historyRequest.getAllergies());
		history.setBackground(historyRequest.getBackground());
		history.setHabits(historyRequest.getHabits());
		history.setVaccines(historyRequest.getVaccines());
		history.setUser(historyRequest.getUser());
		return history;
	}
}
