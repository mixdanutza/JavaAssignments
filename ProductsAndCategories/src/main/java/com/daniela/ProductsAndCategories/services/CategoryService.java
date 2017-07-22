package com.daniela.ProductsAndCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniela.ProductsAndCategories.models.Category;
import com.daniela.ProductsAndCategories.models.Product;
import com.daniela.ProductsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> findCategories(){
		return (List<Category>) categoryRepository.findAll();
	}
	
	public Category getOneById(Long id) {
		return categoryRepository.findOne(id);	 
	}

	public void addProductToCategory(Long categoryId, Product product) {	
			//get category to add to
			Category category=getOneById(categoryId);
			//add product to category list
			List<com.daniela.ProductsAndCategories.models.Product> cProducts=category.getProducts();
			cProducts.add(product);
			//Update category
			addCategory(category);	
	}

	public List<Category> findProductsNotContains(Product oneProduct) {
		List<Category> categories=categoryRepository.findByProductsNotContains(oneProduct);
		return categories;
	}


}
