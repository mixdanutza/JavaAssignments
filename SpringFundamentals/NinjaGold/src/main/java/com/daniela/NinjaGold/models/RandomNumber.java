package com.daniela.NinjaGold.models;

import java.util.Random;

public class RandomNumber {
	
	public static int min;
	public static int max;
	
	public RandomNumber(int min, int max) {

	}
	
	public static int getRandom(int min, int max) {
		Random random= new Random();
		int n = (int )(Math.random() * (max-min+1)+min);
		return n;
	}
	
	


	

}
