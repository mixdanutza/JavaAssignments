package com.codingdojo.pets.models;

public class Dogs extends Animal implements Pet {

	public Dogs(String name, String breed, double weight) {
		super(name, breed, weight);
	}


	public String showAffection(String affection) {
		return affection;
	}

}
