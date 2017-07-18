package com.generator.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.generator.models.Word;

import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*HOME PAGE*");
		HttpSession session =request.getSession();
		int count;
		if(session.getAttribute("count") ==null) {
			 count=0;	
		}else {
			 count = (int)session.getAttribute("count");
			 count++;
		}
		//Save the session as count
		session.setAttribute("count", count);
		
		
		//Generate a random word
		String word= Word.generate();
		System.out.println(word);
		//Set Model for view 
		
		request.setAttribute("word", word);
		
		//Get current date
		String timeStamp = new SimpleDateFormat("EEE, MMM d  yyyy  HH:mm:ss ").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		request.setAttribute("dt", timeStamp);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/main.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
