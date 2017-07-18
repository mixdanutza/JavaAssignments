package com.codingdojo.pets.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.pets.models.Cats;

/**
 * Servlet implementation class Cat
 */
@WebServlet("/Cat")
public class Cat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*** CAT WORKING ***");
		
		//Process request:
		String name = request.getParameter("name");
		String breed= request.getParameter("breed");
		double weight;
		try {
			 weight = Double.parseDouble(request.getParameter("weight"));
		}
		catch(Exception e) {
			 weight = 0;
		}
		
		//Create model
		Cats newCat= new Cats(name, breed, weight);
		
		//set Model for view
		request.setAttribute("newCat", newCat);
		
		//Let view handle the request
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cat.jsp");
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
