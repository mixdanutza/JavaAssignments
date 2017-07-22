<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${oneCategory.name} Category</h1>
	<h2>Products</h2>
	<c:forEach items="${oneCategory.products}" var="pro">
		<p>${pro.name}</p>	
	</c:forEach>
	
	<h2>Add Product:</h2>
	<form action="/addProductToCategory/${oneCategory.id}" method="POST" class="form">
		<select name="productId">
			<c:forEach items="${allProducts}" var="pro">
				<option value="${pro.id}">${pro.name}</option>	
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form>

</body>
</html>