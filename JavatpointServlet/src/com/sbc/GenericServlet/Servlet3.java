package com.sbc.GenericServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Creating Servlet by extending GenericServlet 
 */

@WebServlet("/3")
public class Servlet3 extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();

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

		/* Get parameter values from web-xml using ServletConfig  */
		ServletConfig config = getServletConfig();
		String driver = config.getInitParameter("driver");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		writer.append("<h1>2. ServletConfig Example</h1> ");
		writer.append("<p>1. An object of ServletConfig is created by the web container for each servlet. </p>");
		writer.append("<p>2. This object can be used to get that Servlet's configuration information from web.xml file.  </p>");
		writer.append("<p>3. Create parameters in web-xml using <.init-param></p>");
		writer.append("<p><i> <.servlet> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp; <.init-param> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <.param-name>driver<.param-name> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <.param-value>sun.jdbc.odbc.JdbcOdbcDriver<.param-value> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp; <./init-param> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp; <.init-param> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <.param-name>username<.param-name> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <.param-value>user<.param-value> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp; <./init-param> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp; <.init-param> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <.param-name>password<.param-name> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <.param-value>pass<.param-value> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp; <./init-param> </i></p>");
		writer.append("<p><i> <.servlet> </i></p>");
		
		writer.append("<p>4. Get the values of those parameters in the servlet/class using '.getInitParameter()' method of ServletConfig Interface </p>");
		writer.append("<p><i> ServletConfig  config = getServletConfig(); </i></p>");
		writer.append("<p><i> String  driver = config.getInitParameter('driver'); </i></p>");
		writer.append("<p><i> String  username = config.getInitParameter('username'); </i></p>");
		writer.append("<p><i> String  password = config.getInitParameter('password'); </i></p>");
		writer.append("<p>5. If you can change the parameter values in web-xml, it will update the values in the servlet/servlet class. </p>");
		
		writer.append("<h3>6. Enumerate these parameters using Enumeration</h3>");
		writer.append("<p>1. Using Enumeration you can get both param and values </p>");
		Enumeration<String> e = config.getInitParameterNames();
		while(e.hasMoreElements()) {
			String param = e.nextElement();
			writer.append("<p><i>" + param + " : " + config.getInitParameter(param) + "</i></p>");
		}
		
		/* Get parameter values from web-xml using ServletContext */
		ServletContext context = getServletContext();
		String aUsername = context.getInitParameter("ActiveUsername");
		String aPassword = context.getInitParameter("ActivePassword");
		
		writer.append("<h1>3. ServletContext Example</h1> ");
		writer.append("<p>1. An object of ServletContext is created by the web container during the deployment of the application. </p>");
		writer.append("<p>2. This object is used to get the configuration information of web container from web.xml file.  </p>");
		writer.append("<p>3. When a parameter is initialized using <i><.context-param></i> in web-xml, it is accessible to all the servlets within that web application. </p>");
		writer.append("<p>4. Create parameters in web-xml using <.context-param> </p>");
		writer.append("<p><i> <.web-app> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp; <.context-param> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <.param-name>ActiveUsername<.param-name> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <.param-value>aUser<.param-value> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp; <./context-param> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp; <.context-param> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <.param-name>ActivePassword<.param-name> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <.param-value>aPass<.param-value> </i></p>");
		writer.append("<p><i> &nbsp;&nbsp;&nbsp;&nbsp; <./context-param> </i></p>");
		writer.append("<p><i> <.web-app> </i></p>");
		writer.append("<p>5. Get the values of those parameters in any servlet/class using '.getInitParameter()' method of ServletContext Interface </p>");
		writer.append("<p><i> ServletContext context = getServletContext(); </i></p>");
		writer.append("<p><i> String aUsername = context.getInitParameter('ActiveUsername'); </i></p>");
		writer.append("<p><i> String aPassword = context.getInitParameter('ActivePassword'); </i></p>");
		writer.append("<p><i> String  password = config.getInitParameter('password'); </i></p>");
		writer.append("<p>6. If you can change the parameter values in web-xml, it will update the values in all servlet/class.  </p>");
		
		writer.append("<h3>7. Enumerate context-parameters using Enumeration</h3>");
		writer.append("<p>1. Using Enumeration you can get both param and values </p>");
		Enumeration<String> c = context.getInitParameterNames();
		while(c.hasMoreElements()) {
			String param = c.nextElement();
			writer.append("<p><i>" + param + " : " + context.getInitParameter(param) + "</i></p>");
		}
		
		writer.append("<br/><a href='index.jsp'>Click Here</a> to visit URL 'http://localhost:8080/index.jsp' ");
		writer.append("<br/><a href='index.jsp'>Try </a> to login with invalid username & password. ");
		writer.append("<br/><br/><p><i>Visit 'https://www.javatpoint.com/servlet-tutorial' & see 'Servlet.docx' file</i></p>");
		writer.append("</div>");
		writer.append("</html>");
		writer.close();
	}

}
