package com.daniela.LearningPlatform.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


public class Lesson {
	
	@GetMapping("/m/38/{filename}/{content}")
	public String display(@PathVariable("filename") String filename, @PathVariable("content") String  content, Model model) {
		System.out.println("************");
		String message="";
		if(content.equals("0733")) {
			message+="Setting up your server...";
		}else if(content.equals("0345")) {
			System.out.println("*****");
			message+="Coding Forms ";
		}else if(content.equals("0342")) {
			message+="Punch Cards ";
		}else if(content.equals("0348")) {
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
