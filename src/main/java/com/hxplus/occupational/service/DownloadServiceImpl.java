package com.hxplus.occupational.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Diagnostic;
import com.hxplus.occupational.model.SoapNote;
import com.hxplus.occupational.request.PDFRequest;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class DownloadServiceImpl implements DownloadService {

	@Override
	public ResponseEntity<byte[]> downloadInform(PDFRequest pdfRequest) {
		
		Map<String, Object> map = pdfRequest.getMap();
		
		Consult consult = (Consult) map.get("consult");
		SoapNote soapNote = (SoapNote) map.get("soapnote");
		List<Diagnostic> diagnostics = (List<Diagnostic>) map.get("diagnostics");
		
		consult.setDiagnostics(diagnostics);
		consult.setSoapNote(soapNote);
		
		try{
			
			byte[] contents = printInform(consult).toByteArray();
			
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.parseMediaType("application/pdf"));
		    String filename = "Consult_Inform_"+(new Date().toString().substring(4, 10))+" "+(new Date().toString().substring(23))+".pdf";
		    headers.setContentDispositionFormData(filename, filename);
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		    
		    return new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);

			
		} catch (DocumentException ex){
			System.out.println("Error de documento " + ex.getLocalizedMessage());
			ex.printStackTrace();
			System.out.println("");
			System.out.println("");
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch (Exception ex){
			System.out.println("Error generando el archivo PDF " + ex.getLocalizedMessage());
			ex.printStackTrace();
			System.out.println("");
			System.out.println("");
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private ByteArrayOutputStream printInform(Consult consult) throws DocumentException{
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		Document document = new Document();
		
		PdfWriter.getInstance(document, baos);
		
		document.open();
		document.add(new Paragraph("Hola Mundo!!!"));
		
		/* Resto del documento aquí */
		for(Paragraph paragraph : parseConsult(consult)){
			document.add(paragraph);
		}
		
		document.close();
		
		return baos;
	}
	
	private List<Paragraph> parseConsult(Consult consult){
		List<Paragraph> paragraphs = new ArrayList<>();
		
		SoapNote soapNote = consult.getSoapNote();
		
		if(soapNote != null){
			paragraphs.add(new Paragraph("Se pudo observar:"));
			paragraphs.add(new Paragraph(soapNote.getObjective()));
		}
		
		List<Diagnostic> diagnostics = consult.getDiagnostics(); 
		if(diagnostics != null && !diagnostics.isEmpty()){
			paragraphs.add(new Paragraph("Diagnóstico(s):"));
			
			for(Diagnostic diagnostic : diagnostics){
				paragraphs.add(new Paragraph("\t-" + diagnostic.getDetails()));
			}
		}
		
		if(soapNote.getComments() != null) paragraphs.add(new Paragraph(soapNote.getComments()));
		
		
		return paragraphs;
		
	}

}
