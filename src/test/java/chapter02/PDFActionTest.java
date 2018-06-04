package chapter02;

import chapter02.action.PDFAction;
import chapter02.util.DependencyInjector;

public class PDFActionTest {
	public static void main(String[] args) {
		DependencyInjector dependencyInjector = new DependencyInjector();
		dependencyInjector.start();
		PDFAction pdfAction = (PDFAction) dependencyInjector.getObject(PDFAction.class);
		pdfAction.createPDF("/home/mohan/Downloads/test.pdf", "TEST MESSAGE");
		dependencyInjector.shutdown();
	}
}
