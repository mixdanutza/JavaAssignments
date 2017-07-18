<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Dojo Survey</h1>
	<form method="POST" action="/submitSurvey">
		<input type="text"  name="name" />
		<br><br>
		<select name="location">
			<option value="San Jose">San Jose</option>
			<option value="Seattle">Seattle </option>
			<option value="Chicago">Chicago</option>
			<option value="Philadelphia">Philadelphia</option>
		</select>
		<br><br>
		<select name="language">
			<option value="Java">Java</option>
			<option value="CSharp">CSharp </option>
			<option value="Python">Python</option>
			<option value="MEAN">MEAN</option>
		</select>
		<br><br>
		<textarea  name="comment" ></textarea>
		<br><br>
		<button type="submit">Button</button>
	</form>
</body>
</html>