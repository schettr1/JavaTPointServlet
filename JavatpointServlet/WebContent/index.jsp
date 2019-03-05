<h1>This is 'index.jsp' page</h1>

<form method="POST" action="ValidationServlet">
	<div>
	 <label for="username">Username: 
	 	<input type="text" name="username" />
	 </label>
	</div>
	<div>
	 <label for="password">Password : 
	 	<input type="text" name="password" />
	 </label>
	</div>	
	<div>
	 <input type="submit" />
	</div>	
</form>

<br/><h3>Priority of loading file on start up</h3>
<p>1. if <.url-pattern><b>/</b><./url-pattern> is present in web-xml then load servlet-class, else </p>
<p>2. if <.welcome-file><b>/filename.html</b><./welcome-file> is present in web-xml then load 'filename.html', else</p>
<p>3. if 'index.html' is present in WebContent then load 'index.html', else</p>
<p>4. if 'index.htm' is present in WebContent then load 'index.htm', else</p>
<p>5. if 'index.jsp' from WebContent then load 'index.jsp', else</p>
<p>6. render Page Not Found 404 Error </p>