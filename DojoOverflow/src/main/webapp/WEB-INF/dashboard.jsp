<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Dashboard</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<h1>Question dashboard</h1>

<table class="w3-table-all">
    <thead>
      <tr class="w3-red">
        <th>Question</th>
        <th>Tag</th>
      </tr>
    </thead>
    <c:forEach items="${allQuestions}" var="q">
    <tr>
      <td><a href="/answers/${q.id}">${q.question}</a></td>
      <td>
      <c:forEach items="${q.tags}" var="t">
	      ${t.subject}  
      </c:forEach>
      </td>
    </tr>
    </c:forEach>

  </table>
</div>

<a href="/newQuestion">New Question</a>


</body>
</html>