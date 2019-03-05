package com.sbc.Servlet_Interface;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Creating Servlet by implementing Servlet Interface
 */
@WebServlet("/2")
public class Servlet2 implements Servlet {

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		writer.append("<h1>This is example of creating servlet by implementing Servlet Interface</h1>");
		writer.append("<h3>Servlet can be created by three ways - </h3>");
		writer.append("<p>1. Extending HttpServlet </p>");
		writer.append("<p>2. Extending GenericServlet </p>");
		writer.append("<p>3. Implementing Servlet (Interface) </p><br/>");
		
		writer.append("<h3>Life Cycle of a Servlet</h3> ");
		writer.append("<p>1. Servlet class is loaded. </p>");
		writer.append("<p>2. Servlet Instance is created. Each servlet instance has access to the variable and methods of its Class. </p>");
		writer.append("<p>3. init(--) method is invoked. </p>");
		writer.append("<p>4. service(--, --) method is invoked. </p>");
		writer.append("<p>5. destroy() method is invoked. </p><br/>");
		
		writer.append("<h3>Deploying Servlet</h3> ");
		writer.append("<p>1. To deploy a servlet you need Tomcat or any other server. (remember the diagram Web Server -> Web Container -> Servlet) </p>");
		writer.append("<p>2. To use Tomcat you must add JAVA_HOME in the Environment Variable of the properties of My Computer.  </p>");
		writer.append("<p>3. Create a Dynamic Web Project ( It comes with 'WebContent' which is quintessential project struture ) </p>");
		writer.append("<p>4. Create the Servlet Class using any of the above three methods. </p>");
		writer.append("<p>5. Create NEW -> SERVLET vs. NEW -> CLASS. See 'Servlet.docx'</p><br/>");

		writer.append("<h3> 'ServletCofig' & 'ServletContext' are not allowed in servlet that implements Servlet Interface </h3>");
		writer.append("<br/><a href='3'>Click Here</a> to visit URL 'http://localhost:8080/JavaCoreServlet/3' ");
		writer.append("<h4><i>Visit 'https://www.javatpoint.com/servlet-tutorial' & see 'Servlet.docx' file</i></h4>");
		
		writer.append("</div>");
		writer.append("</html>");
		writer.close();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
