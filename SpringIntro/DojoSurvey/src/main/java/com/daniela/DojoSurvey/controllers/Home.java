package com.daniela.DojoSurvey.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniela.DojoSurvey.models.Survey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class Home {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/info")
	public String inf() {
		
		return "info.jsp";
	}
	
	@GetMapping("/javaLover")
	public String java() {
		return "java.jsp";
	}
	
	@RequestMapping(path="/submitSurvey", method=RequestMethod.POST)
	public String submit(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment", required=false) String comment, Model model, HttpSession session ) {
		
		Survey newSurvey=new Survey(name, location, language, comment);
		session.setAttribute("newSurvey", newSurvey);
		System.out.println("****"+language);
		if(language.equals("Java")){
			System.out.println("**");
			return "redirect:/javaLover";
		}else {
			return "redirect:/info";			
		}
	}
}
