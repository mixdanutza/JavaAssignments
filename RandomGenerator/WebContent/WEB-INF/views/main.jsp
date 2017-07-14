<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.box{
	border: 2px solid black;
	width: 50%;
	padding: 2%;
	text-align:center;
	font-size: 30px;
}
</style>
</head>
<body>
	<h3>You have generated a word  <c:out value="${count}"/>  times.</h3>
	<div class="box"><c:out value="${word}"/></div>
	<form action="/RandomGenerator/Home" method="get">
		<button type="submit">Generate</button>
	</form>
	<hr>
	<h1>The last time you generated a word was:</h1>
	<div class="box"><c:out value="${dt}"/></div>
</body>
</html>