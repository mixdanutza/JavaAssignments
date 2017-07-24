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
<h1>${oneQuestion.question}</h1>

<p><strong>Tags: </strong> <c:forEach items="${oneQuestion.tags}" var="t"> ${t.subject} </c:forEach></p>

<table class="w3-table-all">
    <thead>
      <tr class="w3-red">
        <th>Answers</th>
      </tr>
    </thead>
    <c:forEach items="${oneQuestion.answers}" var="a">
    <tr>
      <td>${a.answer}</td>
    </tr>
    </c:forEach>

  </table>
</div>


<form:form method="POST" action="/answers/new" modelAttribute="answerObject">
    <form:label path="question">Name
    <form:errors path="question"/>
    <form:input type="hidden" path="question" value="${oneQuestion.id}"/></form:label>
    
    <form:label path="answer">Answer
    <form:errors path="answer"/>
    <form:input path="answer"/></form:label>
      
    <input type="submit" value="Submit"/>
</form:form>

<hr>


<a href="/newQuestion">New Question</a>


</body>
</html>