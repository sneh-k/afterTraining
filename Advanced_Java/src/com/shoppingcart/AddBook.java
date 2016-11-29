package com.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		String[] hobbies = request.getParameterValues("Book1");
		HttpSession session = request.getSession();
        List<String> aux=new ArrayList<String>();
        
        
        for(int i=0;i<hobbies.length;i++){
            aux.add(hobbies[i]);
        }
        session.setAttribute("hobbies", aux);
        
//		StringBuilder str=new StringBuilder(" ");
//		for(int i=1;i<hobbies.length;i++)
//		        str=str.append(hobbies[i]);
//		session.setAttribute("hobbies", str);
        
        
		response.sendRedirect("AdddBook2.html");
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
