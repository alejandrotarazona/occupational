package com.hxplus.occupational.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxplus.occupational.model.Habit;
import com.hxplus.occupational.request.HabitRequest;
import com.hxplus.occupational.service.HabitService;

@Controller
@RequestMapping(value="habit")
public class HabitController {
	@Autowired HabitService habitService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Habit getHabit(@PathVariable("id") Long id){
		return habitService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Habit> getHabits(){
		return habitService.findAll();
	}
	
	@RequestMapping(value="/bypatient/{idpatient}", method= RequestMethod.GET)
	public @ResponseBody List<Habit> listBackgroundsByPatient(@PathVariable("idpatient") Long idpatient){
		return habitService.findByPatientId(idpatient);
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Habit createHabit(@RequestBody HabitRequest habitRequest){
		return habitService.saveHabit(habitRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Habit updateHabit(@PathVariable("id") Long id, @RequestBody HabitRequest habitRequest){
		return habitService.updateHabit(id, habitRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteHabit(@PathVariable("id") Long id){
		return habitService.deleteHabit(id);
	}
}
