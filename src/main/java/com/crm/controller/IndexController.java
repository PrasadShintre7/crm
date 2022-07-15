package com.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@GetMapping("/")
	public String login(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		
		return "signup";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		
		return "home";
	}
	
	@GetMapping("/customer")
	public String customer(Model model) {
		
		return "customer";
	}
	
	@GetMapping("/appointment")
	public String appointment(Model model) {
		
		return "appointment";
	}
	
	@GetMapping("/report")
	public String report(Model model) {
		
		return "report";
	}

	
	
}
