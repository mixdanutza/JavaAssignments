<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/ButtonClicker/Button" method="POST">
		<input type="hidden" name="clicked" value="1"/>
		<button>Click Me!</button>
	</form>
	
	<h1 style="color: red;">You have clicked this button  <c:out value="${result}"/>   times.</h1>

</body>
</html>