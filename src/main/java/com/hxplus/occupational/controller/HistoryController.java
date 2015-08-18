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

import com.hxplus.occupational.model.History;
import com.hxplus.occupational.request.HistoryRequest;
import com.hxplus.occupational.service.HistoryService;

@Controller
@RequestMapping(value="history")
public class HistoryController {
	@Autowired HistoryService historyService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody History getHistory(@PathVariable("id") Long id){
		return historyService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<History> getHistorys(){
		return historyService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody History createHistory(@RequestBody HistoryRequest historyRequest){
		return historyService.saveHistory(historyRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody History updateHistory(@PathVariable("id") Long id, @RequestBody HistoryRequest historyRequest){
		return historyService.updateHistory(id, historyRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteHistory(@PathVariable("id") Long id){
		return historyService.deleteHistory(id);
	}
}
