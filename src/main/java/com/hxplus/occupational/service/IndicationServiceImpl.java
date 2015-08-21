package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Indication;
import com.hxplus.occupational.repositories.IndicationRepository;
import com.hxplus.occupational.request.IndicationRequest;
@Service
public class IndicationServiceImpl implements IndicationService {

	@Autowired
	IndicationRepository indicationRepository;

	@Override
	public Indication findById(Long id) {
		return indicationRepository.findOne(id);
	}

	@Override
	public List<Indication> findAll() {
		return indicationRepository.findAll();
	}

	@Override
	public Indication saveIndication(IndicationRequest indicationRequest) {
		return indicationRepository.save(fromReq(new Indication(),
				indicationRequest));
	}

	@Override
	public Indication updateIndication(Long id,
			IndicationRequest indicationRequest) {
		return indicationRepository.save(fromReq(findById(id),
				indicationRequest));
	}

	@Override
	public ResponseEntity<Object> deleteIndication(Long id) {
		try {
			indicationRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Indication fromReq(Indication indication,
			IndicationRequest indicationRequest) {
		indication.setDescription(indicationRequest.getDescription());
		return indication;
	}

}
