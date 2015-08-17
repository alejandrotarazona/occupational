package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Habit;
import com.hxplus.occupational.request.HabitRequest;

public interface HabitService {
	
	public Habit findById(Long id);
	public List<Habit> findAll();
	public Habit saveHabit(HabitRequest habitRequest);
	public Habit updateHabit(Long id, HabitRequest habitRequest);
	public ResponseEntity<Object> deleteHabit(Long id);

}
