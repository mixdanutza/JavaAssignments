<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="new.css">
<style>
	

.formBox{
	margin:10%;
}
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    display:inline-block;
    margin:2px;
    
}
.form{
	display:inline-block;
	width:20%;
	margin:0% 4% 0% 4%;
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

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>
<h1>Add Product</h1>

<form:form method="POST" action="/products/new" modelAttribute="product" class="form">
	<form:label path="name">Name
	<form:errors path="name"/>
	<form:input path="name"/>
	</form:label>
	
	<form:label path="description">Description
	<form:errors path="description"/>
	<form:input path="description"/>
	</form:label>
	
	<form:label path="price">Price
	<form:errors path="price"/>
	<form:input path="price"/>
	</form:label>
	
	<input type="submit" value="Add Product">
</form:form>

</body>
</html>