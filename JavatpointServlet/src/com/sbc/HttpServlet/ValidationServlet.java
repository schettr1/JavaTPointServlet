package com.sbc.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		if(username.equals("user") && password.equals("pass")) {
			/* Forward the request to ConfirmedValidationServlet */
			RequestDispatcher ds = request.getRequestDispatcher("ConfirmedValidationServlet");	
			ds.forward(request, response); 
		}
		else {
			/* Include this content in response */
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.append("<h2>This is an example of .include() method from RequestDispatcher Interface</h2>")
					.append("<p>It includes the content of that servlet(<i>ValidationServlet</i>) which could be HTML page, JSP page or TEXT/HTML in response.</p>")
					.append("<p>'index.jsp' page is included along with this 'text/html' message in the response.</p>")
					.append("<br/><h2>username is 'user' & password is 'pass' </h2>");
			RequestDispatcher ds = request.getRequestDispatcher("/index.jsp");
			ds.include(request, response); 
			
		}
		
	}

}
