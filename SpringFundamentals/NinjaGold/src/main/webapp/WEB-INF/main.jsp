<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<p class="total">Your Gold:  </p>
	<p class="total" id="miniBox"> <c:out value="${total}"/></p>
	
	<div class="four">
		<div class="box"> 
			<p>Farm</p>
			(earns 10-20 gold)
			<form method="POST" action="/submit">
				<input type="hidden" name="location" value="farm" />
				<button class="button">Find Gold</button>
			</form>
		</div>
		<div class="box"> 
			<p>Cave</p>
			(earns 5-10 gold)
			<form method="POST" action="/submit">
				<input type="hidden" name="location" value="farm" />
				<button class="button">Find Gold</button>
			</form>
		</div>
		<div class="box"> 
			<p>House</p>
			(earns 2-5 gold)
			<form method="POST" action="/submit">
			<input type="hidden" name="location" value="house" />
				<button class="button">Find Gold</button>
			</form>
		</div>
		<div class="box"> 
			<p>Casino</p>
			(earns 0-50 gold)
			<form method="POST" action="/submit">
			<input type="hidden" name="location" value="casino" />
				<button class="button">Find Gold</button>
			</form>
		</div>
	</div>
	

	
	<h1>Activities:</h1>
	<div class="scroll" >
		<ul style="list-style-type:circle">
		<c:forEach items="${all}" var="message" >
		  <li  class='<c:out value="${message.getColor()}"/>'  ><c:out value="${message.getMessage()}"/></li>
		</c:forEach>
		</ul>  
	</div>

</body>
</html>