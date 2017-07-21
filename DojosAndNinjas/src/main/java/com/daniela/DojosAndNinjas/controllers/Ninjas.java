package com.daniela.DojosAndNinjas.controllers;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
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
import com.daniela.DojosAndNinjas.models.Ninja;
import com.daniela.DojosAndNinjas.services.DojoService;
import com.daniela.DojosAndNinjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class Ninjas {
	private NinjaService ninjaService;
	private DojoService dojoService;
	public Ninjas(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService=ninjaService;
		this.dojoService=dojoService;
	}
	
	@GetMapping("/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos=dojoService.findAll();
		model.addAttribute("dojos", dojos);	
		System.out.println(dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}	
			return "redirect:/ninjas/new";
		}else {
			ninjaService.addNinja(ninja);
			return "redirect:/dojos/all";
		}
	}

}
