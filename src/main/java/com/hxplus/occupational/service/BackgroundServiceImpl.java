package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Background;
import com.hxplus.occupational.repositories.BackgroundRepository;
import com.hxplus.occupational.request.BackgroundRequest;

@Service
public class BackgroundServiceImpl implements BackgroundService {

	@Autowired
	BackgroundRepository backgroundRepository;

	@Override
	public Background findById(Long id) {
		return backgroundRepository.findOne(id);
	}

	@Override
	public List<Background> findAll() {
		return backgroundRepository.findAll();
	}

	@Override
	public Background saveBackground(BackgroundRequest backgroundRequest) {
		return backgroundRepository.save(fromReq(new Background(),
				backgroundRequest));
	}

	@Override
	public Background updateBackground(Long id,
			BackgroundRequest backgroundRequest) {
		return backgroundRepository
				.saveAndFlush(fromReq(findById(id), backgroundRequest));
	}

	@Override
	public ResponseEntity<Object> deleteBackground(Long id) {
		try {
			backgroundRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Background fromReq(Background background,
			BackgroundRequest backgroundRequest) {
		//background.setName(backgroundRequest.getName());
		background.setDescription(backgroundRequest.getDescription());
		System.out.println("Background cargado.\nProcediendo a guardar");
		return background;
	}
}
