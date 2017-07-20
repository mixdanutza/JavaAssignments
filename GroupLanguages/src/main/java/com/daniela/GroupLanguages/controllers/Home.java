package com.daniela.GroupLanguages.controllers;


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.daniela.GroupLanguages.models.Language;
import com.daniela.GroupLanguages.service.LanguageService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Home {
	private  final LanguageService languageService;
	public   Home(LanguageService languageService) {
		this.languageService=languageService;
	}
		
	@GetMapping("/")
	public String main(Model model, @ModelAttribute("language") Language language, @ModelAttribute("errors") String errors) {
		
		System.out.println(errors);
		
		List<Language> languages=languageService.getLanguages();
		model.addAttribute("languages", languages);
		return "main.jsp";
	}
	
	@PostMapping("/languages/new")
	public String create(@Valid @ModelAttribute("language") Language language , BindingResult result,RedirectAttributes redirectAttributes) {
		List<String> errors=new ArrayList<>();
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				errors.add(error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("errors", errors);
			return "redirect:/";
		}else {
			languageService.addLanguage(language);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/show/{id}")
	public String findByIndex(Model model, @PathVariable("id") long index) {
		Language language=languageService.findByIndex(index);
		model.addAttribute("language", language);
		return "info.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") long index, Model model) {
		Language language=languageService.findByIndex(index);
		if(language != null) {
			model.addAttribute("language", language);
			return "edit.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		languageService.deleteLanguage(id);
		return "redirect:/";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result){
		if(result.hasErrors()) {
			return "edit.jsp";
			
		}else {
			languageService.editLanguage(id, language);
			return "redirect:/";
		}
		
	}

}
