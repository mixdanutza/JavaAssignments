<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.box{
	border: 2px solid black;
	width:50%;
	height:200px;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
</style>
</head>
<body>
	<ul>
	  <li><a href="/m/38/0553/0733">Set up</a></li>
	  <li><a href="/m/38/0483/0345">Forms</a></li>
	  <li><a href="/m/38/0553/0342">Cards</a></li>
	  <li><a href="/m/26/0553/0348">Advanced</a></li>
	  <li><a href="/m/26/0483/2342">Binary</a></li>
	</ul>
	
	<h1>Lesson!</h1>

	<div class="box">
		<c:out value="${message}"/>
	</div>
	
		
		
		

</body>
</html>