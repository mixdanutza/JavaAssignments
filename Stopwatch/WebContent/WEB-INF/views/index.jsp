<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="com.stopwatch.models.Time" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	.forms{
		width: 100px;
		margin: 10px;
		height: 70px;
		display: inline-block;
	}
	input{
		width: 100%;
		height: 50%;
		background-color: #39A7AC;
	}
table {
    width:100%;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
}
table#t01 th {
    background-color: black;
    color: white;
}
</style>
</head>
<body>
	<h1>Stop Watch</h1>
	<br>
	<h2>Current time: <c:out value="${current}"/></h2>
	
	<form class="forms" action="/Stopwatch/Home" method="post">
		<input type="submit" name="start" value="start"/>
	</form>
	
	<form class="forms" action="/Stopwatch/Home" method="post">
		<input type="submit" name="stop" value="stop"/>
	</form>
	
	<form class="forms" action="/Stopwatch/Home" method="post">
		<input type="submit" name="reset" value="reset"/>
	</form>
	
	<% Time newTime=(Time)session.getAttribute("newTime"); %>
	<%if (newTime !=null){ %>
	<% String start=newTime.getStart(); %>
	<% 	if(start== null){
			start="00:00";
		}
	%>
	
	<% String stop=newTime.getStop(); %>
	<% 	if(stop== null){
			stop="00:00";
		}
	%>
	
	<% String d=newTime.getRunning(); %>
	<% 	if(d== null){
			d="00:00";
		}
	%>


	<p>Start:<%=start %>   Stop:<%=stop %>   Difference: <%=d %> </p>
	
	<%} %>
	
	
	
	
	<table id="t01">
	  <tr>
	    <th>Start</th>
	    <th>Stop</th> 
	    <th>Difference</th>
	  </tr>
	  <c:forEach items="${all }" var="t">
	  <tr>
	    <td>${t.getStart()}</td>
	    <td>${t.getStop()}</td>
	    <td>${t.getRunning()}</td>
	  </tr>
	  </c:forEach>  
	  <tr>
	</table>
	
	
	

	

	
</body>
</html>