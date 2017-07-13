<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checker Board</title>
<link href="./style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <!-- getting the value for the name parameter -->
    <% int width = Integer.parseInt(request.getParameter("width")); %>
    <% int height = Integer.parseInt(request.getParameter("height")); %>
    

    <!-- displaying the value -->
    <h1>Checkerboard: <%= width %> X <%= height %> </h1>
    
    
    <%for(int j=0; j<=height; j++){ %>
	    <br>
	    <% if(j%2==1){ %>
		  	 <%for(int i=0; i<=width; i++){ %>
		    	<% if(i%2==1){ %>
		    		<div class="red" ></div>
		   		 <% } else { %>
		   		 <div class="blue"></div>
		  	 <% }  %>
	  	  <% } %>
	   		 <% } else { %>
	   		 <%for(int i=0; i<=width; i++){ %>
		    	<% if(i%2==1){ %>
		    		<div class="blue" ></div>
		   		 <% } else { %>
		   		 <div class="red"></div>
		  	 <% }  %>
	   		<% }  %>
	   	<% }  %>
    

    <% } %>
    
    
</body>
</html>