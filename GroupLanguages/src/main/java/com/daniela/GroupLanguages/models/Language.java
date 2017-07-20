package com.daniela.GroupLanguages.models;


import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="programminglanguages")
public class Language {
	@Id
	@GeneratedValue
	private long id;
	@Column
	@Size(min=2, max=20, message="You name has to be at least 2 characters long ")
	private String name;
	@Column
	@Size(min=2, max=20, message="You name has to be at least 2 characters long ")
	private String creator;
	@Column
	@NotEmpty(message="Please add version")
	private String  version;
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date created_at;
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date updated_at;
	
	
	
    @PrePersist
    protected void onCreate(){
            this.created_at = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
            this.updated_at = new Date();
    } 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Language() {
		
	}
	
	public  Language(String name, String creator, String version) {
		
		this.name=name;
		this.creator=creator;
		this.version=version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	

}
