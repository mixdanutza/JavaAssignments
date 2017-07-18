package com.daniela.DojoSurvey.models;

public class Survey {
	public String  name;
	public String location;
	public String language;
	public String comment;
	
	public Survey(String name, String location, String language, String comment) {
		setName(name);
		setLocation(location);
		setLanguage(language);
		setComment(comment);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
