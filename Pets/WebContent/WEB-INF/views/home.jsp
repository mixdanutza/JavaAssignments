<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/Pets/style.css"   type="text/css">

</head>
<body>
<h1 class="red">Create a cat</h1>

	<form action="/Pets/Cat" method="get">
	<h3>
	    <label for="fname">Name</label>
	    <input type="text" id="fname" name="name" placeholder="Cat name..">
	</h3>
	<h3>
	
	    <label for="lname">Breed</label>
	    <input type="text" id="lname" name="breed" placeholder="Breed..">
	</h3>
	<h3>
		
	    <label for="lname">Weight</label>
	    <input type="text" id="lname" name="weight" placeholder="Weight..">
	    <br>
	</h3>	

	    <input type="submit" value="Submit">
	</form>
	
	<hr>
	
	
	<h1 class="red">Create a dog</h1>

	<form action="/Pets/Dog" method="get">
	<h3>
	    <label for="fname">Name</label>
	    <input type="text" id="fname" name="name" placeholder="Cat name..">
	</h3>
	<h3>
	
	    <label for="lname">Breed</label>
	    <input type="text" id="lname" name="breed" placeholder="Breed..">
	</h3>
	<h3>
		
	    <label for="lname">Weight</label>
	    <input type="text" id="lname" name="weight" placeholder="Weight..">
	    <br>
	</h3>	

	    <input type="submit" value="Submit">
	</form>
</body>
</html>