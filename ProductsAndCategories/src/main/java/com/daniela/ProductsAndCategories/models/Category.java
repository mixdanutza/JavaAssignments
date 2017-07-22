package com.daniela.ProductsAndCategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="categories")
public class Category {
	@Id
    @GeneratedValue
    private Long id;
	
	@Column
	@Size(min=2, max=20)
    private String name;
	
	@CreationTimestamp
    private Date createdAt;
	
	@UpdateTimestamp
    private Date updatedAt;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
      name = "categories_products", 
      joinColumns = @JoinColumn(name = "categoryId"), 
      inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category() {
        
    }
    
    public Category(String name) {
        this.name = name;
        this.createdAt = new Date();
        this.updatedAt = new Date();    
    }
    
	

}
