package com.generator.models;

import java.util.Random;

public class Word {
  
    	public static String generate()
    	  {
    	    final int PASSWORD_LENGTH = 8;
    	    StringBuffer sb = new StringBuffer();
    	    for (int x = 0; x < PASSWORD_LENGTH; x++)
    	    {
    	      sb.append((char)((int)(Math.random()*26)+97));
    	      sb.append(((int)(Math.random()*26)+97));
    	    }
    	    System.out.println(sb.toString());
    	    
    	    return sb.toString();
    	  }
        
    }
