package com.sample.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SimpleServletFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		String testParam = config.getInitParameter("test-param");
		System.out.println("Test Param: " + testParam);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {
		String ipAddress = request.getRemoteAddr();
		System.out.println("IP " + ipAddress + ", Time " + new Date().toString());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		/*
		 * Called before the Filter instance is removed from service by the web
		 * container
		 */
	}
}
