package com.daniela.displaydate.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/getDate")
	public String date(Model model) {
		String timeStamp = new SimpleDateFormat("EEEE,  dd MMM yyyy ").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		
		model.addAttribute("date", timeStamp);
		return "date.jsp";
	}
	
	@RequestMapping("/getTime")
	public String time(Model model) {
		String timeStamp = new SimpleDateFormat("mm:ss a").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		
		model.addAttribute("time", timeStamp);
		return "time.jsp";
	}
}
