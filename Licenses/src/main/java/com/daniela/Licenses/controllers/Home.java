package com.daniela.Licenses.controllers;

import java.util.List;

import javax.naming.Binding;
import javax.naming.spi.DirStateFactory.Result;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.daniela.Licenses.models.License;
import com.daniela.Licenses.models.Person;
import com.daniela.Licenses.services.LicenseService;
import com.daniela.Licenses.services.PersonService;

@Controller
public class Home {
	private final LicenseService licenseService;
	public final PersonService personService;
	public Home(LicenseService licenseService, PersonService personService) {
		this.licenseService=licenseService;
		this.personService=personService;
	}

	//Display main page with Person form
	@GetMapping("/")
	public String home(@ModelAttribute("person") Person person, Model model) {	
		return "main.jsp";
	}
	
	//After submitting Person form create Person
	@PostMapping("/addPerson")
	public String addperson(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "main.jsp";
		}else {
			personService.addPerson(person);
//			return "redirect:/showOnePerson/"+person.getId();	
			return "redirect:/addLicense";
		}
	}
	
	//Display a page with one persons information
	@GetMapping("/showOnePerson/{id}")
	public String showOnePerson(@PathVariable("id") Long id, Model model) {
		Person person=personService.getPersonById(id);
		if(person==null) {
			return "redirect:/";
		}else {
			model.addAttribute("person", person);
			return "person.jsp";
		}
	}
	
	
	
	//Display page License form
	@GetMapping("/addLicense")
	public String addLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons=personService.getNullLicensePersons();
		System.out.println(persons);
		model.addAttribute("persons", persons);
		return "license.jsp";
	}
	
	//Post methot for submiting License form
	@PostMapping("/createLicense")
	public String createLicense(@Valid @ModelAttribute("license") License license,BindingResult result, Model model ) {
		if(result.hasErrors()) {
			return "license.jsp";
		}else {
			licenseService.addLicense(license);
			return "redirect:/all";		
		}
	}
	
	
	//Display a page with all persons and licenses
	@GetMapping("/all")
	public String all(Model model) {
		List<Person> persons=personService.allPersons();
		System.out.println(persons);
		model.addAttribute("persons", persons);
		return "all.jsp";
	}

}
