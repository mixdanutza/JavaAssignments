package com.daniela.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daniela.ProductsAndCategories.models.Category;
import com.daniela.ProductsAndCategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByCategoriesNotContains(Category oneCategory);

}
