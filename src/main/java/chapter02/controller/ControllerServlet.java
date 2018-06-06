package chapter02.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chapter02.action.PDFAction;
import chapter02.action.SaveProductAction;
import chapter02.bean.Product;
import chapter02.form.ProductForm;
import chapter02.util.DependencyInjector;
import chapter02.validator.ProductValidator;

/**
 * use servlet controller
 * @author mohan
 *
 */
/*@WebServlet(name = "ControllerServlet", urlPatterns = {
		"/input-product", "/save-product", "/form", "/pdf"})*/
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1873L;
	private DependencyInjector dependencyInjector;
	
	public void init() {
		dependencyInjector = new DependencyInjector();
		dependencyInjector.start();
	}
	
	public void destroy() {
		dependencyInjector.shutdown();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		process(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		process(request, response);
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		String dispatchUrl = null;
		
		if ("input-product".equals(action)) {
			dispatchUrl = "/jsp/productForm.jsp";
		} else if ("save-product".equals(action)) {
			ProductForm productForm = new ProductForm();
			productForm.setName(request.getParameter("name"));
			productForm.setDescription(request.getParameter("description"));
			productForm.setPrice(request.getParameter("price"));
			
			ProductValidator productValidator = new ProductValidator();
			List<String> errors = productValidator.validate(productForm);
			if (errors.isEmpty()) {
				Product product = new Product();
				product.setName(productForm.getName());
				product.setDescription(productForm.getDescription());
				product.setPrice(new BigDecimal(productForm.getPrice()));
				
				SaveProductAction saveProductAction = new SaveProductAction();
				saveProductAction.save(product);
				
				request.setAttribute("product", product);
				dispatchUrl = "/jsp/productDetail.jsp";
			} else {
				request.setAttribute("errors", errors);
				request.setAttribute("form", productForm);
				dispatchUrl = "/jsp/productForm.jsp";
			}
		} else if ("form".equals(action)) {
			dispatchUrl = "/jsp/form.jsp";
		} else if ("pdf".equals(action)) {
			HttpSession session = request.getSession(true);
			String sessionId = session.getId();
			PDFAction pdfAction = (PDFAction) dependencyInjector.getObject(PDFAction.class);
			String text = request.getParameter("text");
			String path = request.getServletContext().getRealPath("/result") + sessionId + ".pdf";
			pdfAction.createPDF(path, text);
			
			request.setAttribute("msg", "The file has been created.");
			dispatchUrl = "/jsp/form.jsp";
		}
		
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
}
