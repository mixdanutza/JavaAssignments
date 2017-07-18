package com.codingdojo.pets.models;

public class Cats extends Animal implements Pet{

	public Cats(String name, String breed, double weight) {
		super(name, breed, weight);
	}

	public String showAffection(String affection) {
		return affection;
	}
	
}
