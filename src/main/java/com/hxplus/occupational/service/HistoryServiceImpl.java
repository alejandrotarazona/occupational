package com.hxplus.occupational.service;

import java.util.ArrayList;
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
import com.hxplus.occupational.repositories.HistoryRepository;
import com.hxplus.occupational.request.AllergyRequest;
import com.hxplus.occupational.request.HabitRequest;
import com.hxplus.occupational.request.HistoryRequest;
import com.hxplus.occupational.request.VaccineRequest;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	HistoryRepository historyRepository;

	@Autowired
	BackgroundService backgroundService;

	@Autowired
	AllergyService allergyService;
	@Autowired
	HabitService habitService;
	@Autowired
	VaccineService vaccineService;

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
		History history = historyRepository.saveAndFlush(fromReq(new History(),
				historyRequest));

		ArrayList<Allergy> allergies = new ArrayList<>();
		ArrayList<Habit> habits = new ArrayList<>();
		ArrayList<Vaccine> vaccines = new ArrayList<>();

		for (AllergyRequest allergyRequest : historyRequest.getAllergies()) {
			allergyRequest.setHistory(history);
			allergies.add(allergyService.saveAllergy(allergyRequest));
		}

		for (HabitRequest habitRequest : historyRequest.getHabits()) {
			habitRequest.setHistory(history);
			habits.add(habitService.saveHabit(habitRequest));
		}

		for (VaccineRequest vaccineRequest : historyRequest.getVaccines()) {
			vaccineRequest.setHistory(history);
			vaccines.add(vaccineService.saveVaccine(vaccineRequest));
		}

		history.setAllergies(allergies);
		history.setHabits(habits);
		history.setVaccines(vaccines);

		return history;
	}

	@Override
	public History updateHistory(Long id, HistoryRequest historyRequest) {
		return historyRepository.save(fromReq(findById(id), historyRequest));
	}

	@Override
	public ResponseEntity<Object> deleteHistory(Long id) {
		try {
			historyRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private History fromReq(History history, HistoryRequest historyRequest) {
		Background background = backgroundService.saveBackground(historyRequest.getBackground());
		history.setBackground(background);
		return history;
	}
}
