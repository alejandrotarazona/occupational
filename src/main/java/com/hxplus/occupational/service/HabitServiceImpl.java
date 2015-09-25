package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Habit;
import com.hxplus.occupational.repositories.HabitRepository;
import com.hxplus.occupational.request.HabitRequest;

@Service
public class HabitServiceImpl implements HabitService {

	@Autowired HabitRepository habitRepository;
	
	@Override
	public Habit findById(Long id) {
		return habitRepository.findOne(id);
	}

	@Override
	public List<Habit> findAll() {
		return habitRepository.findAll();
	}

	@Override
	public Habit saveHabit(HabitRequest habitRequest) {
		return habitRepository.saveAndFlush(fromReq(new Habit(), habitRequest));
	}

	@Override
	public Habit updateHabit(Long id, HabitRequest habitRequest) {
		return habitRepository.save(fromReq(findById(id), habitRequest));
	}

	@Override
	public ResponseEntity<Object> deleteHabit(Long id) {

		try{
			habitRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Habit fromReq(Habit habit, HabitRequest habitRequest){
		habit.setName(habitRequest.getName());
		habit.setFrecuency(habitRequest.getFrecuency());
		habit.setHistory(habitRequest.getHistory());
		return habit;
	}
}
