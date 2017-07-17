package com.daniela.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	
	@RequestMapping("/")
	public String home() {
		return "forward:/home.html";
	}
	
	@RequestMapping("/projects")
	public String projects() {
		return "forward:/project.html";
	}	
	
	@RequestMapping("/aboutMe")
	public String about() {
		return "forward:/about.html";
	}	
	

}
