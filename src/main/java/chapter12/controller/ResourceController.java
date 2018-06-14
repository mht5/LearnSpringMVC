package chapter12.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import chapter12.domain.Login;

@Controller
public class ResourceController {
	
	@RequestMapping(value = "/login")
	public String login(@ModelAttribute Login login, HttpSession session, Model model) {
		model.addAttribute("login", new Login());
		if ("user".equals(login.getUserName()) && "123".equals(login.getPassword())) {
			session.setAttribute("loggedIn", true);
			return "download";
		} else {
			return "loginForm";
		}
	}
	
	@RequestMapping(value = "/download-resource")
	public String downloadResource(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, @RequestHeader String referer, Model model) {

		if (referer != null) {
			System.out.println("referer: " + referer);
			
			if (session == null || session.getAttribute("loggedIn") == null) {
				model.addAttribute("login", new Login());
				return "loginForm";
			}
			
			String filePath = request.getServletContext().getRealPath("/WEB-INF/image");
			Path file = Paths.get(filePath, "img1.jpg");
			if (Files.exists(file)) {
				response.setContentType("application/jpg");
				response.addHeader("Content-Disposition", "attachment;filename=test.jpg");
				try {
					Files.copy(file, response.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
