package com.daniela.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	 @RequestMapping("/")
	 public String main(HttpSession session, Model model) {
		 if(session.getAttribute("counter") ==null) {
			 int count=1;
			 session.setAttribute("counter", count);
		 }else {
			 int count= (int)session.getAttribute("counter");
			 count++;
			 session.setAttribute("counter", count);
		 }
		 return "index.jsp";
	 }
	 
	 @RequestMapping("/counter")
	 public String seeCounter() {
		 return "counter.jsp";
	 }
}
