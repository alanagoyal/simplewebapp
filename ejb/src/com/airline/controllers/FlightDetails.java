package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightLocal_ejb;
import com.airline.service.FlightRemote;
import com.airline.service.FlightServiceStatelessBean;

/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(beanName = "flightStateless")
	private FlightLocal_ejb fs;
	
	@EJB(beanName = "flightStateless")
	private FlightLocal_ejb fs2;
	
	@EJB(beanName = "flightStateful")
	private FlightLocal_ejb fsStateful;
	
	@EJB(beanName = "flightStateful")
	private FlightLocal_ejb fsStateful2;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("The flight details servlet has been called...");
		
		// Stateless
		out.println("Flight Details: " + fs.getFrom() + " to " + fs.getTo());
		
		fs2.setFrom("Paris");
		fs2.setTo("Rome");
		
		out.println("Flight Details: " + fs.getFrom() + " to " + fs.getTo());

		// Stateful
		out.println("Flight Details: " + fsStateful.getFrom() + " to " + fsStateful.getTo());
		
		fsStateful2.setFrom("Paris");
		fsStateful2.setTo("Rome");
		
		out.println("Flight Details: " + fsStateful.getFrom() + " to " + fsStateful.getTo());

		out.println("Flight Details: " + fsStateful2.getFrom() + " to " + fsStateful2.getTo());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}