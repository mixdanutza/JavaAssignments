package com.daniela.ProductsAndCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniela.ProductsAndCategories.models.Category;
import com.daniela.ProductsAndCategories.models.Product;

import com.daniela.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> findProducts(){
		return (List<Product>) productRepository.findAll();
	}

	public Product getOneById(Long id) {
		return productRepository.findOne(id);	 
	}

	public void addCategoryToProduct(Long productId, com.daniela.ProductsAndCategories.models.Category category) {
		//get product to add to
		Product product=getOneById(productId);
		//add category to product
		List<com.daniela.ProductsAndCategories.models.Category> pCategories=product.getCategories();
		pCategories.add(category);
		//Update product
		addProduct(product);
	}

	public List<Product> findByCategoriesNotContains(Category oneCategory) {
		List<Product> products=productRepository.findByCategoriesNotContains(oneCategory);
		return products;
	}
}
