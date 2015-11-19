package com.hxplus.occupational.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Diagnostic;
import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.model.SoapNote;
import com.hxplus.occupational.request.PDFRequest;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class DownloadServiceImpl implements DownloadService {

	private Patient patient;
	private Doctor doctor;
	private Company company;

	@Autowired
	ConsultService consultService;
	@Autowired
	SoapNoteService soapNoteService;
	@Autowired
	DiagnosticService diagnosticService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	CompanyService companyService;
	@Autowired
	CostCenterService costCenterService;
	@Autowired
	PatientService patientService;
	@Autowired
	UserService userService;

	@Override
	public ResponseEntity<byte[]> downloadInform(PDFRequest pdfRequest) {

		String[] clausules = pdfRequest.getToPrint();
		Consult consult = pdfRequest.getConsult();
		consult = consultService.findById(consult.getId());

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.parseMediaType("application/pdf"));
			String filename = "Consult_Inform_"
					+ (consult.getConsultDate().toString().substring(0, 10))
					+ ".pdf";
			headers.setContentDispositionFormData(filename, filename);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

			byte[] contents = printInform(clausules, consult).toByteArray();

			return new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);

		} catch (NullPointerException ex) {
			ex.printStackTrace();
			System.out.println("");
			System.out.println("");
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (DocumentException ex) {
			System.out
					.println("Error de documento " + ex.getLocalizedMessage());
			ex.printStackTrace();
			System.out.println("");
			System.out.println("");
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception ex) {
			System.out.println("Error generando el archivo PDF "
					+ ex.getLocalizedMessage());
			ex.printStackTrace();
			System.out.println("");
			System.out.println("");
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private ByteArrayOutputStream printInform(String[] clausules,
			Consult consult) throws DocumentException, NullPointerException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, baos);

		document.open();

		Calendar calendar = Calendar.getInstance();
		Chunk[] chunk = {
				new Chunk("IMFORME MÉDICO\n", new Font(
						Font.FontFamily.TIMES_ROMAN, 24, Font.ITALIC)),
				new Chunk(calendar.get(Calendar.DATE) + "/"
						+ calendar.get(Calendar.MONTH) + "/"
						+ calendar.get(Calendar.YEAR), new Font(
						Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)) };

		Paragraph topHeader = new Paragraph(chunk[0]);
		topHeader.add(chunk[1]);
		topHeader.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(topHeader);

		/* Encabezado del documento */
		for (Paragraph paragraph : createDocumentHeader(consult)) {
			document.add(paragraph);
		}

		// add a couple of blank lines
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);

		/* Resto del documento aquí */
		for (Paragraph paragraph : parseConsult(clausules, consult)) {
			document.add(paragraph);
		}

		// add a couple of blank lines
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);

		/* Pie de página */
		for (Paragraph paragraph : createDocumentFooter(consult)) {
			document.add(paragraph);
		}

		document.close();

		return baos;
	}

	private List<Paragraph> createDocumentHeader(Consult consult) {
		List<Paragraph> paragraphs = new ArrayList<>();
		List<String> data = new ArrayList<>();

		patient = patientService.findByConsultId(consult.getId());
		doctor = doctorService.findByConsultId(consult.getId());

		patient.setUser(userService.fingByPatientId(patient.getId()));
		doctor.setUser(userService.findById(doctor.getUser().getId()));

		company = companyService.findById(doctor.getUser().getEmployer()
				.getId());

		company.setMainLocation(costCenterService.findById(company
				.getMainLocation().getId()));

		Paragraph header = new Paragraph(company.getCompanyName(), new Font(
				Font.FontFamily.TIMES_ROMAN, 24, Font.ITALIC));
		header.setAlignment(Paragraph.ALIGN_RIGHT);

		paragraphs.add(header);

		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

		data.add(company.getMainLocation().getAddress());
		data.add(company.getMainLocation().getPhoneNumber());
		data.add("Dr. " + doctor.getUser().getFirstName() + " "
				+ doctor.getUser().getLastName());

		String phone = doctor.getUser().getPhoneNumber();
		if (doctor.getUser().getPhoneNumber() == null)
			phone = "No tiene teléfono registrado";

		data.add("Teléfono: " + phone);
		data.add("Paciente: " + patient.getUser().getFirstName() + " "
				+ patient.getUser().getLastName());

		for (String sentence : data) {
			header = new Paragraph(sentence, font);
			header.setAlignment(Paragraph.ALIGN_RIGHT);
			paragraphs.add(header);
		}

		return paragraphs;
	}

	private List<Paragraph> createDocumentFooter(Consult consult) {
		List<Paragraph> paragraphs = new ArrayList<>();		
		
		Chunk[] chunks = {
			new Chunk("                                            ",new Font(Font.FontFamily.TIMES_ROMAN,24,Font.ITALIC)),
			new Chunk(doctor.getUser().getFirstName() + " " + doctor.getUser().getLastName(), new Font(Font.FontFamily.TIMES_ROMAN,12,Font.ITALIC)),
			new Chunk("Registrado con el nro: " + doctor.getRegNumber(),new Font(Font.FontFamily.TIMES_ROMAN,12,Font.ITALIC))
		};
		
		chunks[0].setUnderline(0.2f, -2f);
		
		for(Chunk chunk : chunks){
			Paragraph paragraph = new Paragraph(chunk);
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			paragraphs.add(paragraph);
		}

		return paragraphs;
	}

	private List<Paragraph> parseConsult(String[] clausules, Consult consult) {

		List<Paragraph> paragraphs = new ArrayList<>();
		List<String> listClausules = Arrays.asList(clausules);
		SoapNote soapNote = soapNoteService.findById(consult.getId());

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(consult.getConsultDate());
		paragraphs.add(new Paragraph("Fecha de la consulta: "
				+ calendar.get(Calendar.DATE) + "/"
				+ calendar.get(Calendar.MONTH) + "/"
				+ calendar.get(Calendar.YEAR)));

		if (soapNote != null && listClausules.contains("objective")) {
			paragraphs.add(new Paragraph("Se pudo observar:"));
			paragraphs.add(new Paragraph(soapNote.getObjective()));
		}

		List<Diagnostic> diagnostics = diagnosticService
				.findByConsultId(consult.getId());
		if (listClausules.contains("diagnostics")) {
			paragraphs.add(new Paragraph("Diagnóstico(s):"));

			for (Diagnostic diagnostic : diagnostics) {
				paragraphs.add(new Paragraph("\t-" + diagnostic.getDetails()));
			}

			if (diagnostics == null || diagnostics.isEmpty()) {
				paragraphs.add(new Paragraph("No se realizó diagnóstico"));
			}
		}

		if (listClausules.contains("plan")) {
			paragraphs.add(new Paragraph("Plan:"));

			if (soapNote.getPlan() == null)
				paragraphs.add(new Paragraph(
						"No se elaboró plan de tratamiento"));
			paragraphs.add(new Paragraph(soapNote.getPlan()));
		}

		if (listClausules.contains("comments")) {
			paragraphs.add(new Paragraph("Comentarios adicionales:"));
			if (soapNote.getComments() == null)
				paragraphs.add(new Paragraph("No hay comentarios adicionales"));
			paragraphs.add(new Paragraph(soapNote.getComments()));
		}

		return paragraphs;

	}

}
