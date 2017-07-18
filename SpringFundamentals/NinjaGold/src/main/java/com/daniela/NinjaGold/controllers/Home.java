package com.daniela.NinjaGold.controllers;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniela.NinjaGold.models.RandomNumber;
import com.daniela.NinjaGold.models.messageList;

@Controller
public class Home {
	
	
	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("total")==null) {
			int total=0;
			session.setAttribute("total", total);
			
		}
		return "main.jsp";
	}
	
	@PostMapping("/submit")
	public String farm(Model model, HttpSession session, @RequestParam(value="location", required=true) String location) {
		int total=(int)session.getAttribute("total");
		String current = new SimpleDateFormat("MMMM dd YYYY hh:mm a").format(Calendar.getInstance().getTime());
		int rand;
		String message="";
		String color="";
		
		if(location.equals("farm")) {
			 rand=RandomNumber.getRandom(10, 20);		
			
		}else if(location.equals("cave")) {
			 rand=RandomNumber.getRandom(5, 10);
		}else if(location.equals("house")) {
			 rand=RandomNumber.getRandom(2, 5);
		}else if(location.equals("casino")) {
			 rand=RandomNumber.getRandom(-50, 50);
		}else {
			return "redirect:/";
		}
		
		if(rand>=0) {
			color="green";
			message="You entered "+location+" and earned "+rand+" gold. (" +current+") <code>:smile:</code>";
		}else {
			color="red";
			message="You entered "+location+" and lost  "+rand+" gold. Ouch... (" +current+") 😢";
		}
	
		total+=rand;
		session.setAttribute("total", total);
		
		messageList.addMessage(color, message);
		session.setAttribute("all", messageList.all);
		System.out.println(message);
		System.out.println(messageList.all);
		System.out.println("POST******");
		return "redirect:/";	
	}



}
