<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1>New Person</h1>

<c:out value="${per.license.number}"/>

<form:form method="POST" action="/addPerson" modelAttribute="person" class="form">
    <form:label path="firstname">First Name
    <form:errors path="firstname"/>
    <form:input path="firstname"/></form:label>
    <form:label path="lastname">Last Name
    <form:errors path="lastname"/>
    <form:input path="lastname"/></form:label>
    <input type="submit" value="Submit"/>
</form:form>



</body>
</html>