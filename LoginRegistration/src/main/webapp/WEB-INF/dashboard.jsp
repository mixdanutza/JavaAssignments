<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>hello ${currentUser.firstName}</h1>
	
	<p><strong>Roles:</strong><c:forEach items="${currentUser.roles}" var="role"> ${role.name}</c:forEach></p>
	
	<p>First Name: ${currentUser.firstName}</p>
	<p>Last Name: ${currentUser.lastName}</p>
	<p>Email: ${currentUser.username}</p>
	<p>Sign up date: ${currentUser.createdAt}</p>
	<form id="logoutForm" method="POST" action="/logout">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="submit" value="Logout!" />
	</form>
</body>
</html>