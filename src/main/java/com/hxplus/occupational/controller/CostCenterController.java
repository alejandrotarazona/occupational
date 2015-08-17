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

import com.hxplus.occupational.model.CostCenter;
import com.hxplus.occupational.request.CostCenterRequest;
import com.hxplus.occupational.service.CostCenterService;

@Controller
@RequestMapping(value = "/costcenter")
public class CostCenterController {

	@Autowired
	CostCenterService costCenterService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	CostCenter getCostCenter(@PathVariable("id") Long id) {
		return costCenterService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<CostCenter> findAll() {
		return costCenterService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public CostCenter createCostCenter(
			@RequestBody CostCenterRequest costCenterRequest) {
		return costCenterService.saveCostCenter(costCenterRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public CostCenter updateCostCenter(@PathVariable("id") Long id,
			@RequestBody CostCenterRequest costCenterRequest) {
		return costCenterService.updateCostCenter(id, costCenterRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCostCenter(@PathVariable("id") Long id) {
		return costCenterService.deleteCostCenter(id);
	}

}
