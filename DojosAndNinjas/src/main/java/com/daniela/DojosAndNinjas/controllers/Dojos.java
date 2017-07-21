package com.daniela.DojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.daniela.DojosAndNinjas.models.Dojo;
import com.daniela.DojosAndNinjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class Dojos {
	private DojoService dojoService;
	public Dojos(DojoService dojoService) {
		this.dojoService=dojoService;
	}
	
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		
		return "newDojo.jsp";
	}
	@PostMapping("/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "redirect:/dojos/new";
		}else {
			dojoService.addDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	@GetMapping("/all")
	public String showAll(Model model){
		Dojo dojo=dojoService.findOneById(4);
		model.addAttribute("dojo", dojo);
		return "dojoNinjas.jsp";
	}

}
