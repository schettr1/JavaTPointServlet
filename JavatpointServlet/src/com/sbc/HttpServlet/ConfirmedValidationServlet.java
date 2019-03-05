package com.sbc.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConfirmedValidationServlet")
public class ConfirmedValidationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		writer.append("<h1>forward() vs. sendRedirect() vs include() </h1>")
				.append("<h2>1. forward() method from RequestDispatcher Interface</h2>")
				.append("<p>.forward() method forwards/transfers the request from current servlet(<i>ValidationServlet</i>) to next servlet(<i>ConfirmedValidationServlet</i>) or page.</p>")
				.append("<p>It does not show the content of the forwarding servlet. </p>")
				.append("<p>Remember, the URL will display the name of forwarding servlet(<i>i.e. ValidationServlet</i>) when the request is completed. </p>")
				.append("<p>i.e. Request from ValidationServlet is forwarded to ConfirmedValidationServlet but the URL shows <i>'http://localhost:8080/JavaCoreServlet/ValidationServlet'</i></p>")
				.append("<p>It has problems while submitting form because if you refresh browser or hit submit button twice then same request is send to the server twice and duplicate data is posted in database.</p>")
				.append("<h3>This content is generated from ConfirmedValidationServlet</h3>")
				.append("<p><i>i. Username: " + username + "</i></p>")
				.append("<p><i>ii. Password: " + password + "</i></p><br/>")
				.append("<br/><h2>2. sendRedirect() method from HttpServlet </h2>")
				.append("<p>.sendRedirect() method also forwards/transfers the request from current servlet(<i>ValidationServlet</i>) to next servlet(<i>ConfirmedValidationServlet</i>) or page.</p>")
				.append("<p>It also does not show the content of the forwarding servlet. </p>")
				.append("<p>But, the URL will display the name of re-directed servlet(<i>i.e. ConfirmedValidationServlet</i>) when the request is completed. </p>")
				.append("<p>i.e. When request from ValidationServlet is forwarded to ConfirmedValidationServlet the URL will show <i>'http://localhost:8080/JavaCoreServlet/ConfirmedValidationServlet'</i></p>")
				.append("<p>It is better than .forward() because it solves the problem of not re-submitting the form when you refresh the browser but when you submit the empty form null values is posted to database.</p>")
				.append("<p>The best approach to submit form is to use Form-Validation & .sendRedirect() to re-direct the page (see <b>GoldTeamProject</b>) </p>")
				.append("<br/><h2>3. include() method from RequestDispatcher Interface </h2>")
				.append("<p>.include() method loads the content of the given page/file/servlet in the current servlet(<i>ValidationServlet</i>) or page.</p>")
				.append("<p>It shows the content of the current servlet and the page/file included in this method. </p>")
				.append("<p>It also shows the URL of current servlet(<i>ValidationServlet</i>) or page from where .include() method has been called. </p>")
				.append("<br/><a href='1'>Click Here</a> to visit URL 'http://localhost:8080/JavaCoreServlet/1' ");
		
		
		
		
		
		
				/*
				
				if(username.equals("user") && password.equals("pass")) {
					response.sendRedirect("ConfirmedValidationServlet");
				}
				else {
					response.sendRedirect(request.getContextPath() + "/index.jsp");
				}
				*/
				
		writer.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("<h2>This is doGet method of ConfirmedValidationServlet. </h2>");

	}

}
