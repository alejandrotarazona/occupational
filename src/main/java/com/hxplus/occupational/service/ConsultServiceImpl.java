package com.hxplus.occupational.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Diagnostic;
import com.hxplus.occupational.model.Exam;
import com.hxplus.occupational.model.Instruction;
import com.hxplus.occupational.model.Prescription;
import com.hxplus.occupational.model.VitalSign;
import com.hxplus.occupational.repositories.ConsultRepository;
import com.hxplus.occupational.request.ConsultRequest;
import com.hxplus.occupational.request.DiagnosticRequest;
import com.hxplus.occupational.request.ExamRequest;
import com.hxplus.occupational.request.InstructionRequest;
import com.hxplus.occupational.request.PrescriptionRequest;
import com.hxplus.occupational.request.VitalSignRequest;

@Service
public class ConsultServiceImpl implements ConsultService {

	@Autowired
	ConsultRepository consultRepository;
	@Autowired
	SoapNoteService soapNoteService;
	@Autowired
	PrescriptionService prescriptionService;
	@Autowired
	InstructionService instructionService;
	@Autowired
	VitalSignService vitalSignService;
	@Autowired
	FileService fileService;
	@Autowired
	DiagnosticService diagnosticService;
	@Autowired
	ExamService examService;

	@Override
	public Consult findById(Long id) {
		return consultRepository.findOne(id);
	}

	@Override
	public List<Consult> findAll() {
		return consultRepository.findAll();
	}

	// @Override
	// public List<Consult> findAllByIdHistory(Long idHistory) {
	// return consultRepository.finfAllByIdHistory(idHistory);
	// }

	@Override
	public List<Consult> findByIdPatient(Long idPatient) {
		return consultRepository.findByPatient(idPatient);
	}

	@Override
	public Consult saveConsult(ConsultRequest consultRequest) {
		Consult consult = fromReq(new Consult(), consultRequest), newConsult;

		try {
			consult.setSoapNote(soapNoteService.saveSoapNote(consultRequest
					.getSoapNote()));
		} catch (Exception ex) {
			System.out.println("Error en SOAPnote");
		}

		consult.setConsultDate(new Date());
		newConsult = consultRepository.save(consult);

		List<Prescription> prescriptions = new ArrayList<>(); // check
		List<Instruction> instructions = new ArrayList<>(); // check
		List<VitalSign> vitalSigns = new ArrayList<>();

//		List<File> files = new ArrayList<>();
		List<Diagnostic> diagnostics = new ArrayList<>(); // check
		List<Exam> examsRequested = new ArrayList<>(), examsRecieved = new ArrayList<>();

		try {
			for (Exam exam : consultRequest.getRecieveExams()) {
				List<Consult> recievedAt = new ArrayList<>();
				recievedAt.add(newConsult);
				exam.setReceived(recievedAt);
				
				ExamRequest examRequest = new ExamRequest();
				examRequest.setReceived(recievedAt);
				examRequest.setResults(exam.getResults());
				
				System.out.println("Examen:\n\tID: " + exam.getId());
				System.out.println("\tResults ID: "+exam.getResults().getId());
				
				examsRecieved.add(examService.updateExam(exam.getId(), examRequest));
			}
		} catch (Exception ex) {
			System.out.println("Error con los recibidos");
			ex.printStackTrace();
		}

		try {
			for (PrescriptionRequest prescriptionRequest : consultRequest
					.getPrescriptions()) {
				prescriptionRequest.setConsult(newConsult);
				prescriptions.add(prescriptionService
						.savePrescription(prescriptionRequest));
			}
		} catch (Exception ex) {
			System.out.println("No prescripciones");
		}

		try {
			for (DiagnosticRequest diagnosticRequest : consultRequest
					.getDiagnostics()) {
				diagnosticRequest.setConsult(newConsult);
				diagnostics.add(diagnosticService
						.saveDiagnostic(diagnosticRequest));
			}
		} catch (Exception ex) {
			System.out.println("No diagnósticos");
		}

		try {
			for (InstructionRequest instructionRequest : consultRequest
					.getInstructions()) {
				instructionRequest.setConsult(newConsult);
				instructionRequest.setDiagnostics(diagnostics);
				instructions.add(instructionService
						.saveInstruction(instructionRequest));
			}
		} catch (Exception ex) {
			System.out.println("No instrucciones");
		}

		try {
			for (VitalSignRequest vitalSignRequest : consultRequest
					.getVitalSigns()) {
				vitalSignRequest.setConsult(newConsult);
				vitalSigns
						.add(vitalSignService.saveVitalSign(vitalSignRequest));
			}
		} catch (Exception ex) {
			System.out.println("No signos vitales");
		}

/*		try {
			for (FileRequest fileRequest : consultRequest.getFiles()) {
				fileRequest.setConsult(newConsult);
				files.add(fileService.saveFile(fileRequest));
			}
		} catch (Exception ex) {
			System.out.println("No archivos");
		}
*/
		try {
			for (ExamRequest examRequest : consultRequest.getRequestExams()) {
				examRequest.setOrdered(newConsult);
				examsRequested.add(examService.saveExam(examRequest));
			}
		} catch (Exception ex) {
			System.out.println("No examenes solicitados");
		}

		return newConsult;
	}

	@Override
	public Consult updateConsult(Long id, ConsultRequest consultRequest) {
		return consultRepository.save(fromReq(findById(id), consultRequest));
	}

	@Override
	public ResponseEntity<Object> deleteConsult(Long id) {
		try {
			consultRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Consult fromReq(Consult consult, ConsultRequest consultRequest) {
		consult.setConsultDate(consultRequest.getConsultDate());
		consult.setDoctor(consultRequest.getDoctor());
		consult.setPatient(consultRequest.getPatient());
		consult.setRecieveExams(consultRequest.getRecieveExams());

		System.out.println("Paciente: " + consult.getPatient().getId());

		return consult;
	}

}
