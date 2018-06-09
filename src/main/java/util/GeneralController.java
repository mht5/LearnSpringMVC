package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import chapter01.bean.Address;

@Controller
public class GeneralController {
	
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
	
	@RequestMapping(value= "/jstl")
	public String jstl(Model model) {
		String  email = "test.gmail.com";
		Date date = new Date();
		Address address = new Address();
		Map<String, String> capitals = new HashMap<String, String>();
		List<String> cities = new ArrayList<String>();
		String[] myArray = {"you", "reap", "what", "you", "sow"};
		
		capitals.put("China", "Beijing");
		capitals.put("Russia", "Mosco");
		capitals.put("America", "DC");
		capitals.put("England", "London");
		capitals.put("France", "Paris");
		capitals.put("Germany", "Berlin");
		
		cities.add("Chongiqng");
		cities.add("Chengdu");
		cities.add("Hangzhou");
		cities.add("Beijing");
		cities.add("New York");
		cities.add("London");
		cities.add("Paris");
		cities.add("Berlin");
		
		model.addAttribute("email", email);
		model.addAttribute("date", date);
		model.addAttribute("address", address);
		model.addAttribute("capitals", capitals);
		model.addAttribute("cities", cities);
		model.addAttribute("myArray", myArray);
		return "jstl";
	}
}
