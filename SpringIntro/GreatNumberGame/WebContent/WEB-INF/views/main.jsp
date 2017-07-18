<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	.red{
		background-color: red;
		width:200px;
		height:200px;
		text-align:center;
		color:white;
		padding-top: 30px;
	}
	.green{
		background-color: green;
		width:200px;
		height:200px;
		text-align:center;
		color:white;
		padding-top:30px;
	}
</style>
</head>
<body>
	<h1>Welcome to the Great Number Game!</h1>
	<h2>I am thinking of a number between 1 and 100</h2>
	<h2>Take a guess</h2>
	<form action="/GreatNumberGame/Home" method="post">
		<input type="text" name="guess" />
		<br>
		<br>
		<button>Submit</button>
	</form>
	
	
	<% if(request.getAttribute("output")=="right"){ %>
		<h1 class="green">Just Right</h1>
	<%} %>
		<% if(request.getAttribute("output")=="high"){ %>
		<h1 class="red">Too high</h1>
	<%} %>
		<% if(request.getAttribute("output")=="low"){ %>
		<h1 class="red">Too Low</h1>
	<%} %>
	
	
	

</body>
</html>