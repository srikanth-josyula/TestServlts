package com.sample.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyAppServletContextListener 
               implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
				ServletContext servletContext = arg0.getServletContext();
				Timer timer = (Timer)servletContext.getAttribute ("timer");
				if (timer != null)
					System.out.println("Application Started Time "+timer);
					timer.cancel();
				servletContext.removeAttribute ("timer");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");
		ServletContext servletContext = arg0.getServletContext();
		try{
			Calendar calendar = Calendar.getInstance();
			Date startTime = calendar.getTime();
			servletContext.setAttribute ("timer", startTime);
		}
		catch (Exception e) {
			servletContext.log ("Problem initializing the task that was to run hourly: " + e.getMessage ());
		}
		
	}
}
