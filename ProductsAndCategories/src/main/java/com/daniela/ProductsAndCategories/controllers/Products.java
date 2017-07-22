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

import com.daniela.ProductsAndCategories.models.Product;
import com.daniela.ProductsAndCategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class Products {
	//Injecting productService
	private ProductService productService;
	public Products(ProductService productService) {
		this.productService=productService;
	}
	
	//Display new product page (form)
	@GetMapping("/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		return "newProduct.jsp";
	}
	
	//Process form adding new PRODUCT
	@PostMapping("/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()){
			for(ObjectError error: result.getAllErrors()){
				System.out.println(error.getDefaultMessage());
			}
			return "newProduct.jsp";
		}else{
			productService.addProduct(product);
			return "redirect:/oneProduct/"+product.getId();
		}
	}
	

	
	
	
}
