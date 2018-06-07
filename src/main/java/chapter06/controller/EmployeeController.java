package chapter06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import chapter06.domain.Employee;

@Controller
public class EmployeeController {
	
	@RequestMapping(value = "/add-employee")
	public String inputEmployee(Model model) {
		model.addAttribute(new Employee());
		return "employeeForm";
	}
	
	@RequestMapping(value = "/save-employee")
	public String saveEmployee(@ModelAttribute Employee employee,
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			@SuppressWarnings("unused")
			FieldError fieldError = bindingResult.getFieldError();
			return "employeeForm";
		}
		System.out.println("Saving employee date...");
//		model.addAttribute("employee", employee);
		return "employeeDetail";
	}
}
