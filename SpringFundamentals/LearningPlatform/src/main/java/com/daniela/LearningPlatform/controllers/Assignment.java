package com.daniela.LearningPlatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/m/26")
public class Assignment {
	
	@RequestMapping("/{filename}/{content}")
	public String show(@PathVariable String filename, @PathVariable String  content, Model model) {
		String message="";
		if(content.equals("0348")) {
			message+="Advanced Fortran Intro";
		}else if(content.equals("2342")) {
			message+="Fortran to Binary ";
		}
		
		model.addAttribute("message", message);
		
		
		if(filename.equals("0553")) {
			return "lesson.jsp";
		}else {
			return "assignment.jsp";
		}
		
	}

}
