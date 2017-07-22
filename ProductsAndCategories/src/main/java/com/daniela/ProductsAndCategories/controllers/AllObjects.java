package com.daniela.ProductsAndCategories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniela.ProductsAndCategories.models.Category;
import com.daniela.ProductsAndCategories.models.Product;
import com.daniela.ProductsAndCategories.services.CategoryService;
import com.daniela.ProductsAndCategories.services.ProductService;

@Controller
public class AllObjects {
	private ProductService productService;
	private CategoryService categoryService;
	
	public AllObjects(ProductService productService, CategoryService categoryService) {
		this.productService=productService;
		this.categoryService=categoryService;
	}
	
	//Get all the Categories and products and Display all page
	@GetMapping("/")
	public String showAll(Model model) {
		List<Product> products=productService.findProducts();
		List<Category> categories=categoryService.findCategories();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "all.jsp";
	}
	
	
	//Display last added product
	@GetMapping("/oneProduct/{id}")
	public String showOneProduct(@PathVariable("id") Long id,Model model) {
		//get last product added by the id passed through the route variable
		Product oneProduct=productService.getOneById(id);
		model.addAttribute("oneProduct", oneProduct);
		//get all categories 
		if(oneProduct!=null) {
			List<Category> allCategories=categoryService.findProductsNotContains(oneProduct);
			model.addAttribute("allCategories", allCategories);
			return "oneProduct.jsp";
		}else {
			return "oneProduct.jsp";
		}
	}
	
	//Display last added category
	@GetMapping("/oneCategory/{id}")
	public String showOneCategory(@PathVariable("id") Long id,Model model) {
		//get last category by id sent through as path variable
		Category oneCategory=categoryService.getOneById(id);
		model.addAttribute("oneCategory", oneCategory);
		System.out.println("**********************************************");
		//get all products for displaying 
		List<Product> allProducts=productService.findByCategoriesNotContains(oneCategory);
		model.addAttribute("allProducts", allProducts);
		return "oneCategory.jsp";
	}
	
	//Add category to product 
	@PostMapping("/addCategoryToProduct/{productId}")
	public String addCategoryToProduct(Model model, @PathVariable("productId") Long productId, @RequestParam(value="categoryId") Long categoryId) {
		//find category 
		Category category=categoryService.getOneById(categoryId);
		//use product service for adding category to the product
		productService.addCategoryToProduct(productId, category);				
		return "redirect:/oneProduct/"+productId;
	}
	
	//Add product to category 
	@PostMapping("/addProductToCategory/{categoryId}")
	public String addProductToCategory(Model model, @PathVariable("categoryId") Long categoryId, @RequestParam(value="productId") Long productId) {
		//find product 
		Product product=productService.getOneById(productId);
		//use category service for adding product to the category
		categoryService.addProductToCategory(categoryId, product);				
		return "redirect:/oneCategory/"+categoryId;
	}
	
}
