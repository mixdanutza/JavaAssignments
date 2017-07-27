<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Registration</title>
<link rel="stylesheet" type="tetx/css" href="style.css">
</head>
<style>
.error{
	color:red;
}
.formBox{
	margin:0% 40% 0% 40%;
}
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=email], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=password] select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
.password{
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;

}
.submitBtn{
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>

<body>
<c:if test="${logoutMessage != null}">
    <c:out value="${logoutMessage}"/>
</c:if>

<p><form:errors path="user.*"/></p>
<div class="formBox">
	<h1>Login</h1>
    <form method="POST" action="/login">
        <p>
            <label for="username">Email</label>
            <input type="email" id="username" name="username"/>
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
	        Email:
	        <strong class="error"><form:errors path="username"/></strong>   
	        <form:input path="username"/>
	    </p>
	    <p>
	        First Name:
	       	<strong class="error"><form:errors path="firstName"/></strong>  
	        <form:input path="firstName"/>
	
	    </p>
	    <p>
	        Last Name:
	        <strong class="error"><form:errors path="lastName"/></strong>  
	        <form:input path="lastName"/>
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