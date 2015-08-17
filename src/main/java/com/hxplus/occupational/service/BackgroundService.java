package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Background;
import com.hxplus.occupational.request.BackgroundRequest;

public interface BackgroundService {
	
	public Background findById(Long id);
	public List<Background> findAll();
	public Background saveBackground(BackgroundRequest backgroundRequest);
	public Background updateBackground(Long id, BackgroundRequest backgroundRequest);
	public ResponseEntity<Object> deleteBackground(Long id);

}
