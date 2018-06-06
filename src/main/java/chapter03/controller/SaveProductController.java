package chapter03.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import chapter02.action.SaveProductAction;
import chapter02.bean.Product;
import chapter02.form.ProductForm;
import chapter02.validator.ProductValidator;

public class SaveProductController implements Controller{
	
	private static final Log logger = LogFactory.getLog(InputProductController.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("SaveProductController.handleRequest()");
		
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
			
			return new ModelAndView("productDetail", "product", product);
		} else {
			return new ModelAndView("productForm", "errors", errors);
		}
	}

}
