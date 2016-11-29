package com.servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.serialize.Printer;

@WebServlet(
        urlPatterns = "/welcome",
        initParams = @WebInitParam(name = "driverName", value = "com.jdbc.oracle.OracleDriver")
) 

public class WelcomeServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		String driver=getInitParameter("driverName");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("usern");
		String password=request.getParameter("passd");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(username.equals(password))
			out.println("<html><body><h1> " + username + " Login Successful..</h1></body></html>");
		else
			out.println("<html><body><h1>Login UnSuccessful..</h1></body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
