package com.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowBook
 */
@WebServlet("/ShowBook")
public class ShowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		HttpSession session=request.getSession(false);
		 response.setContentType("text/html");  
		 PrintWriter out = response.getWriter(); 
//		 out.println(session.getAttribute("username"));
		 out.println("<html><body>");
		 out.println("<h1> User : " + session.getAttribute("username") + "</h1>");
		 out.println("<h1>Shopping Cart : </h1><form action=\"Controller?forward=Logout\" method=\"POST\"><h3><ul>");		
		 
		 
		 
		 List<String> hobb=new ArrayList<String>();
		 hobb=(List<String>)session.getAttribute("hobbies");
		 for(String s : hobb)
			 out.println("<li>"+s+"</li>");
		 
		 String str2[]=request.getParameterValues("Book2");
		 for(String s : str2)
			 out.println("<li>"+s+"</li>");
		 out.println("</ul></h3><input type=\"submit\" value=\"Logout\"></form></body></html>");
	
	}
	
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
