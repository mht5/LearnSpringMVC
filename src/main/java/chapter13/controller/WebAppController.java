package chapter13.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = "/getWebAppDir")
	public String getWebAppDirectory(Model model) {
		model.addAttribute("webAppDir", servletContext.getRealPath("/"));
		return "success";
	}
}
