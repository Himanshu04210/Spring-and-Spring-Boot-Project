package com.masai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@GetMapping("/home")
	public String launchIndexPage() {
		
		return "index";
		//logical name of physical jsp
	}
	
	@GetMapping("/add")
	public String addNumberLauncher() {
		return "addnumber";
	}
	
	@GetMapping("/first")
	public String firstRequestHandler(Integer num1, Integer num2, Model model) {
	
		//SL + DAL + DB
		
		Integer result = num1+num2;
		
		model.addAttribute("resultdata", result);
		
		return "output";
		
	}
	
	@GetMapping("/login")
	public String loginPageLauncher() {
		return "login";
	}
	
	@PostMapping("/second")
	public String loginHandler(String username, String password) {
		
		if(username.equals("admin") && password.equals("1234"))
			return "success";
		else
			return "error";		
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "Welcome to Webservice";
	}
	
	
}
