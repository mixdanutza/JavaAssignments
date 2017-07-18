package com.stopwatch.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stopwatch.models.Time;

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
		String current = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Current time: "+current);
		request.setAttribute("current", current);
		//get all the sessions
		ArrayList<Time> all= Time.getAll();
		System.out.println(all);
		request.setAttribute("all", all);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST CONTROLLER");
		String current = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		HttpSession session=request.getSession();
		
		if(session.getAttribute("newTime") ==null) {
			Time newTime=new Time();
			session.setAttribute("newTime", newTime);		
		}
		
		if(request.getParameter("start") !=null) {
			Time newT=(Time)session.getAttribute("newTime");
			newT.setStart(current);
			System.out.println("Set start time:"+newT.getStart());
			
		}else if(request.getParameter("stop") !=null ) {	
			Time newT=(Time)session.getAttribute("newTime");
			newT.setStop(current);
			System.out.println("Set stop Time: "+newT.getStop());

			
				String dif="";
				try {
					dif = newT.getRunningTime();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Difference: "+dif);
				newT.setRunning(dif);				
				Time.addToList(newT);
				
				if (session != null) {
				    session.invalidate();
				}
				
		
			
		}else if(request.getParameter("reset") !=null) {
			if (session != null) {
			    session.invalidate();
			}
		}
		
		
		
		
		doGet(request, response);
	}

}
