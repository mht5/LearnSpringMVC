package chapter02.util;

import chapter02.action.PDFAction;
import chapter02.service.PDFService;

public class DependencyInjector {
	public void start() {
		System.out.println("DependencyInjector.start()");
	}
	
	public void shutdown() {
		System.out.println("DependencyInjector.shutdown()");
	}
	
	public Object getObject(Class type) {
		if (type == PDFService.class) {
			return new PDFService();
		} else if (type == PDFAction.class){
			PDFService pdfService = (PDFService) getObject(PDFService.class);
			PDFAction pdfAction = new PDFAction();
			pdfAction.setPDFService(pdfService);
			return pdfAction;
		}
		return null;
	}
}
