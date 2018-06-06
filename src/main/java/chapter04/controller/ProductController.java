package chapter04.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import chapter02.bean.Product;
import chapter02.form.ProductForm;
import chapter02.validator.ProductValidator;
import chapter04.service.ProductService;

/**
 * annotation based controller
 * @author mohan
 *
 */
@Controller
public class ProductController {
	private static final Log logger = LogFactory.getLog(ProductController.class);
	
//	ʹ��@Autowiredע��ʵ���Զ�ע�����@Serviceע�����
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/input-product")
	public String inputProduct() {
		logger.info("ProductController.inputProduct()");
		return "productForm";
	}
	
	@RequestMapping(value="/save-product")
	public String saveProduct(ProductForm productForm, RedirectAttributes redirectAttributes) {
		logger.info("ProductController.saveProduct()");
		
		ProductValidator productValidator = new ProductValidator();
		List<String> errors = productValidator.validate(productForm);
		if (errors.isEmpty()) {
			Product product = new Product();
			product.setName(productForm.getName());
			product.setDescription(productForm.getDescription());
			product.setPrice(new BigDecimal(productForm.getPrice()));
			
			Product savedProduct = productService.add(product);
			
			/**
			 * �˴�ʹ���ض��򣬼�ʹ�û�ˢ��ҳ�棬Ҳ�����ظ�ִ�д˷���
			 */
			redirectAttributes.addFlashAttribute("message", "The product has been successfully added.");
			return "redirect:/view-product/" + savedProduct.getId();
			
			/**
			 * ת�����ض���죬��Ϊ�ض�����Ҫ�����ͻ���
			 * �˴�ʹ��ת��������û�ˢ��ҳ�棬�����ᱻ����ִ��
			 */
//			model.addAttribute("product", product);
//			return "productDetail";
		} else {
			redirectAttributes.addFlashAttribute("message", "The product has not been successfully added.");
			return "productForm";
			
//			model.addAttribute("errors", errors);
//			model.addAttribute("form", productForm);
//			return "productForm";
		}
	}
	
	@RequestMapping(value="/view-product/{id}")
	public String viewProduct(@PathVariable Long id, Model model) {
		Product product = productService.get(id);
		model.addAttribute("product", product);
		return "productDetail";
	}
}
