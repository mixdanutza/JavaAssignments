package com.daniela.TheCode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Home {
	
	@GetMapping("/")
	public String home(@ModelAttribute("error") String error) {
		if(error!=null) {
			System.out.println(error);
		}
		return "home.jsp";
	}
	
	@PostMapping("/guess")
	public String code(@RequestParam(value="secret") String input, RedirectAttributes redirectAttributes ) {
		if(input.equals("bushido")) {
			return "code.jsp";
		}else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
			
		}
	}

}
