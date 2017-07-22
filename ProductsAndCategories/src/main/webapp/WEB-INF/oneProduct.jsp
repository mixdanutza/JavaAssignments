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
	<h1>${oneProduct.name}</h1>
	<h2>Categories</h2>
	<c:forEach items="${oneProduct.categories}" var="cat">
		<p>${cat.name}</p>	
	</c:forEach>
	
	<h2>Add Category:</h2>
	<form action="/addCategoryToProduct/${oneProduct.id}" method="POST" class="form">
		<select name="categoryId">
			<c:forEach items="${allCategories}" var="cat">
				<option value="${cat.id}">${cat.name}</option>	
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form>

</body>
</html>