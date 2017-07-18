package com.daniela.NinjaGold.models;

import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class messageList {
	public String color;
	public String message;
		
	public static ArrayList<messageList> all=new ArrayList<messageList>();
	
	public messageList(String color, String message ) {
		setColor(color);
		setMessage(message);
	}
	
	
	public  String getColor() {
		return color;
	}

	public  void setColor(String color) {
		this.color = color;
	}


	public  String getMessage() {
		return message;
	}


	public  void setMessage(String message) {
		this.message = message;
	}


	public static  void addMessage(String color, String message) {
		messageList obj=new messageList(color, message);
		all.add(obj);	
	}
}
