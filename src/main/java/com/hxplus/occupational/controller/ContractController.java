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

import com.hxplus.occupational.model.Contract;
import com.hxplus.occupational.request.ContractRequest;
import com.hxplus.occupational.service.ContractService;

@Controller
@RequestMapping(value="contract")
public class ContractController {
	@Autowired ContractService contractService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Contract getContract(@PathVariable("id") Long id){
		return contractService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Contract> getContracts(){
		return contractService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Contract createContract(@RequestBody ContractRequest contractRequest){
		return contractService.saveContract(contractRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Contract updateContract(@PathVariable("id") Long id, @RequestBody ContractRequest contractRequest){
		return contractService.updateContract(id, contractRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteContract(@PathVariable("id") Long id){
		return contractService.deleteContract(id);
	}
}