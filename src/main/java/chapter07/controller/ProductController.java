package chapter07.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import chapter07.domain.Product;

@Controller
public class ProductController {
	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	/**
	 * 将验证器传到WebDataBinder，会使该验证器应用于Controller类中所有方法
	 * @param binder
	 */
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new ProductValidator());
		binder.validate();
	}*/
	
	@RequestMapping(value = "/add-product")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productForm_1";
	}
	
	@RequestMapping(value = "/save-product")
	public String saveProduct(@Valid @ModelAttribute Product product,
			BindingResult bindingResult, Model model) {
		
//		ProductValidator productValidator = new ProductValidator();
//		productValidator.validate(product, bindingResult);
		
		if (bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			logger.debug("Code: " + fieldError.getCode() + ", field: " + fieldError.getField());
			return "productForm_1";
		}
		
		model.addAttribute("product", product);
		return "productDetail";
	}
}
