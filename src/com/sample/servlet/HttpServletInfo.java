package com.sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HttpServletInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("username");
		out.print("Welcome "+n);
		doPost(request,response);
		out.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter pr = response.getWriter();
		
		pr.println("=== Paths ===\n");
		pr.println("Request URL : " + request.getRequestURL());
		pr.println("Request URI : " + request.getRequestURI());
		pr.println("Servlet path : " + request.getServletPath());
		
		pr.println("Servlet Timer : " + request.getServletContext().getAttribute("timer"));
		
		pr.println("\n=== Headers ===\n");
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String param = (String) e.nextElement();
			pr.println(param + " : " + request.getHeader(param));
		}
		
		pr.println("\n=== Parameters ===\n");
		Map<String, String[]> paramsMap = request.getParameterMap();
		for (String key : paramsMap.keySet()) {
			pr.println(key + " : " + request.getParameter(key));
		}
		
		pr.println("\n=== Session ===\n");
		// returns 0:0:0:0:0:0:0:1 if executed from localhost
		pr.println("Client IP address : " + request.getRemoteAddr());
		pr.println("Session ID : " + request.getRequestedSessionId());
		// Cookie objects the client sent with this request
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				pr.print(cookie.getName() + ";");
			}
		}
	}
	
	// Method to handle POST method request.
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		doGet(request,response);
	}

}
