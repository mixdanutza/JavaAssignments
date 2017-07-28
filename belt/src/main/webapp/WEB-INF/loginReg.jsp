<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Registration</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

<c:if test="${logoutMessage != null}">
    <c:out value="${logoutMessage}"/>
</c:if>
<p><form:errors path="user.*"/></p>
<div class="formBox">
<c:out value="${success}"/>
<c:if test="${errorMessage != null}">
    <c:out value="${errorMessage}"/>
</c:if>
	<h1>Login</h1>
    <form method="POST" action="/login">
        <p>
            <label for="username">Email</label>
            <input  type="text" id="username" name="username"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" class="password" name="password"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login!"/>
    </form>
 </div>

<br>
<div class="formBox">
	<h1>Register</h1>
	<form:form action="/registration" method="POST" modelAttribute="user">
	    <p>
	        Username:
	        <strong class="error"><form:errors path="username"/></strong>   
	        <form:input path="username"/>
	    </p>
	    <p>
	        Email:
	       	<strong class="error"><form:errors path="email"/></strong>  
	        <form:input path="email"/>
	
	    </p>
	    <p>
	        Password:
	        <strong class="error"><form:errors path="password"/></strong>  
	        <form:input type="password" path="password" class="password"/>
	    </p>
	    <p>
	        Confirm Password: 
	        <strong class="error"><form:errors path="passwordConfirm"/></strong> 
	        <form:input type="password" path="passwordConfirm" class="password" />
	    </p>
	    <button class="submitBtn" type="submit">Register</button>
	</form:form>
</div>
</body>
</html>