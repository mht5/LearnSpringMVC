<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add PDF Form</title>
</head>
<body>
	<form method="post" action="pdf">
		<h1>Add Product</h1>
		<p style="color: blue">${msg}</p>
		<label>
			<span>Content: </span>
			<input id="text" type="text" name="text" value="${form.text}">
		</label>
		<label>
			<span>&nbsp;</span>
			<input type="submit" value="Submit" />
		</label>
	</form>
</body>
</html>