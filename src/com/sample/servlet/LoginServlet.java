package com.sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("Welcome to :: "+getServletContext().getInitParameter("name"));
		
		String usd=request.getParameter("username");
		String pwd=request.getParameter("userpass");
		
		String actUsd = getServletConfig().getInitParameter("username");
		String actpwd = getServletConfig().getInitParameter("password");
		
		if(usd.equals(actUsd)){
			if(actpwd.equals(pwd)) {
				RequestDispatcher rd=request.getRequestDispatcher("info");
				rd.forward(request,response);
			}
		}
		else{
			out.print("Sorry username or password error");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request,response);
		}
		
		out.close();
	}

}
