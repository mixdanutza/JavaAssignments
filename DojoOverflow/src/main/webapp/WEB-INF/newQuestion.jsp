<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Question</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<h1>New  Question</h1>
  <form action="/addQuestion" method="POST">
    <div class="form-group">
      <label for="question">Question:</label>
      <input type="text" class="form-control"  name="question" placeholder="Enter question">
    </div>
    <div class="form-group">
      <label for="tag">Tag:</label>
      <input type="text" class="form-control"  name="tag" placeholder="Enter tag">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
	


<a href="/newQuestion" target="_blank">New Question</a>


</body>
</html>