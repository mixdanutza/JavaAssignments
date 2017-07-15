package com.greatnumbergame.controllers;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greatnumbergame.models.RandomNumber;

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
		
		HttpSession session=request.getSession();
		if(session.getAttribute("randNum")==null) {
			String randNum= RandomNumber.getRandomNumber();
			session.setAttribute("randNum", randNum);
		}
		String rand=(String) session.getAttribute("randNum");
		System.out.println("Random number:" + rand);
		
		String output="";
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/main.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		HttpSession session=request.getSession();
		String input=request.getParameter("guess");
		String rand=(String)session.getAttribute("randNum");
		String output="";
		
		
		try {
			Integer.parseInt(input);
			if(Integer.parseInt(input)==Integer.parseInt(rand)) {
				output="right";
				if(session !=null) {
					session.invalidate();
				}
			}else if(Integer.parseInt(input)>Integer.parseInt(rand)) {
				output="high";			
			}else if(Integer.parseInt(input)<Integer.parseInt(rand)) {
				output="low";			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("output", output);
		doGet(request, response);
	}

}
