package com.greatnumbergame.models;

import java.util.Random;

public class RandomNumber {
	
	
	public static String getRandomNumber() {
		Random rn = new Random();
		
		String answer="";

		for(int i =0; i < 2; i++)
		{
		    answer+= Integer.toString(rn.nextInt(10) + 1);
		}
		
		return answer;
	}
}
