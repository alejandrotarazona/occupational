package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Allergy;
import com.hxplus.occupational.model.Background;
import com.hxplus.occupational.model.Habit;
import com.hxplus.occupational.model.History;
import com.hxplus.occupational.model.Vaccine;
import com.hxplus.occupational.repositories.AllergyRepository;
import com.hxplus.occupational.repositories.BackgroundRepository;
import com.hxplus.occupational.repositories.HabitRepository;
import com.hxplus.occupational.repositories.HistoryRepository;
import com.hxplus.occupational.repositories.VaccineRepository;
import com.hxplus.occupational.request.HistoryRequest;
@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired HistoryRepository historyRepository;
	@Autowired BackgroundRepository backgroundRepository;
	@Autowired AllergyRepository allergyRepository;
	@Autowired HabitRepository habitRepository;
	@Autowired VaccineRepository  vaccineRepository;

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
	
	public History saveHistory(History history){
		Background background = history.getBackground();
		List<Allergy> allergies = history.getAllergies();
		List<Habit> habits = history.getHabits();
		List<Vaccine> vaccines = history.getVaccines();
		
		history.setBackground(backgroundRepository.save(background));
		
		history = historyRepository.save(history);
		
		for(Allergy allergy: allergies){
			allergy.setHistory(history);
		}
		
		for(Habit habit : habits){
			habit.setHistory(history);	
		}
		
		for(Vaccine vaccine : vaccines){
			vaccine.setHistory(history);
		}
		
		allergyRepository.save(allergies);
		habitRepository.save(habits);
		vaccineRepository.save(vaccines);
		
		allergyRepository.flush();
		habitRepository.flush();
		vaccineRepository.flush();

		return history;
	}

	private History fromReq(History history, HistoryRequest historyRequest){
		history.setBackground(historyRequest.getBackground().toBackground());
		return history;
	}
}
