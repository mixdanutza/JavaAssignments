package com.daniela.DojosAndNinjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="dojos")
public class Dojo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column
	@Size(min=2, max=20)
	private String name;
	
    @CreationTimestamp
    private Date createdAt;
    
    
    @UpdateTimestamp
    private Date updatedAt;
    
    @OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
    private List<Ninja> ninjas;
    
    
    
    public Dojo() {
    	
    }
    
    public Dojo(String name) {
    	this.name=name;
    	this.createdAt= new Date();
    	this.updatedAt= new Date();
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

	public void setCreatedat(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedat() {
		return updatedAt;
	}

	public void setUpdatedat(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

}
