package chapter02.action;

import chapter02.service.PDFService;

public class PDFAction {
	private PDFService pdfService;
	
	public void setPDFService(PDFService pdfService) {
		this.pdfService = pdfService;
	}
	
	public void createPDF(String path, String input) {
		pdfService.createPDF(path, input);
	}
}
