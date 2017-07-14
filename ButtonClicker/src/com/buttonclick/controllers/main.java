package com.buttonclick.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class main
 */
@WebServlet("/Button")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		int count;
		if(session.getAttribute("count") ==null) {
			 count=0;	
		}else {
			 count = (int)session.getAttribute("count");
		}
		session.setAttribute("count", count);
		System.out.println("GET >>>>>>>"+session.getAttribute("count"));
		int result=(int) session.getAttribute("count");
		request.setAttribute("result", result );
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/main.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN POST NOW***");
		HttpSession session =request.getSession();
		int count;
		if(session.getAttribute("count") !=null) {
			count = (int)session.getAttribute("count");
			count ++;	
			
		}else {
			count=0;
		}
		session.setAttribute("count", count);
		doGet(request, response);
	}

}
