package com.daniela.ProductsAndCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniela.ProductsAndCategories.models.Category;
import com.daniela.ProductsAndCategories.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class Categories {
	private CategoryService categoryService;
	public  Categories(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	//Display page with new category form
	@GetMapping("/new")
	public String newPageGategory(@ModelAttribute("category") Category category, Model model) {
		return "newCategory.jsp";
	}
	
	//Create new category
	@PostMapping("/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "newCategory.jsp";		
		}else {
			categoryService.addCategory(category);
			return "redirect:/oneCategory/"+category.getId();
		}
	}

}
