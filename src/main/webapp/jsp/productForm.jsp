<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Form</title>
</head>
<body>
	<form method="post" action="save-product">
		<h1>Add Product</h1>
		${empty requestScope.errors? "" : "<p style='color:red'>Error(s)!<ul>"}
		<!-- ${requestScope.errors.stream().map(x -> "--><li>"+=x+="</li><!--").toList()} -->
		${empty requestScope.errors? "" : "</ul></p>"}
		<label>
			<span>Product Name: </span>
			<input id="name" type="text" name="name" value="${form.name}">
		</label>
		<label>
			<span>Description: </span>
			<input id="description" type="text" name="description" value="${form.description}">
		</label>
		<label>
			<span>Price: </span>
			<input id="price" type="number" name="price" step="any" value="${form.price}">
		</label>
		<label>
			<span>&nbsp;</span>
			<input type="submit" value="Submit" />
		</label>
	</form>
</body>
</html>