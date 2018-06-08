package chapter08.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ELController {
	@RequestMapping(value= "/el")
	public String el(Model model) {
		List<String> cities = new ArrayList<String>();
		cities.add("Chongiqng");
		cities.add("Chengdu");
		cities.add("Hangzhou");
		cities.add("Beijing");
		cities.add("New York");
		cities.add("London");
		cities.add("Paris");
		cities.add("Berlin");
		model.addAttribute("cities", cities);
		return "el";
	}
}
