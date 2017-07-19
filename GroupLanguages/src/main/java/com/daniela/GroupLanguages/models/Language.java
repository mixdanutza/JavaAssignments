package com.daniela.GroupLanguages.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Language {
	@Size(min=2, max=20, message="You name has to be at least 2 characters long ")
	private String name;
	@Size(min=2, max=20, message="You name has to be at least 2 characters long ")
	private String creator;
	@NotEmpty(message="Please add version")
	private String  version;
	
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
