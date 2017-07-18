package com.codingdojo.pets.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.pets.models.Cats;
import com.codingdojo.pets.models.Dogs;

/**
 * Servlet implementation class Dog
 */
@WebServlet("/Dog")
public class Dog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*** DOG WORKING ***");
		
		//Process request:
		String name = request.getParameter("name");
		String breed= request.getParameter("breed");
		double weight;
		String affection;
		try {
			 weight = Double.parseDouble(request.getParameter("weight"));
		}
		catch(Exception e) {
			 weight = 0;
		}
		
		
		//Create model
		Dogs newDog= new Dogs(name, breed, weight);
		
		if(weight>30.0) {
			 affection=newDog.showAffection("Yor dog loves you. ");
		}else {
			 affection=newDog.showAffection("Yor dog stares at you.");
		}
		//set Model for view
		request.setAttribute("newDog", newDog);
		request.setAttribute("affection", affection);
		
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/dog.jsp");
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
