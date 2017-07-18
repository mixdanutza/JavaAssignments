package com.example.HelloHuman.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
	
	@RequestMapping("/")
	public String home(@RequestParam(value="firstName", defaultValue="Human" )  String first,@RequestParam(value="lastName", defaultValue="Being" )  String last, Model model) {
		
		model.addAttribute("firstName", first);
		model.addAttribute("lastName", last);
		return "index.jsp";
	}

}
