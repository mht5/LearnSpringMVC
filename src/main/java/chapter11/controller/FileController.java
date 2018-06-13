package chapter11.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import chapter11.domain.UploadedFile;

@Controller
public class FileController {
	
	@RequestMapping(value = "/upload-file")
	public String uploadFile() {
		return "uploadFile";
	}
	
	@RequestMapping(value = "/save-file")
	public void saveFile(HttpServletRequest request,@ModelAttribute UploadedFile uploadedFile, Model model) {
		MultipartFile multipartFile = uploadedFile.getMultipartFile();
		String fileName = multipartFile.getOriginalFilename();
		File file = new File(request.getServletContext().getRealPath("/WEB-INF/image"), fileName);
		try {
			multipartFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed");
//		return "productDetail";
	}
}
