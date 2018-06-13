package chapter11.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import chapter11.domain.Product;

@Controller
public class ProductController {
	
	@RequestMapping(value = "/input-product")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productForm";
	}
	
	@RequestMapping(value = "/save-product")
	public String saveProduct(HttpServletRequest request,@ModelAttribute Product product, Model model) {
		List<MultipartFile> files = product.getFiles();
		List<String> fileNames = new ArrayList<String>();
		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {
				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				File file = new File(request.getServletContext().getRealPath("/WEB-INF/image"), fileName);
				try {
					multipartFile.transferTo(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		for (String fileName : fileNames) {
			System.out.println(fileName);
		}
		return "productDetail";
	}
}
