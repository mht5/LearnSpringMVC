<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Product Form</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<form method="post" enctype="multipart/form-data" action="save-product">
			<h1>Add Product</h1>
			${empty requestScope.errors? "" : "<p style='color:red'>Error(s)!<ul>"}
			<!-- ${requestScope.errors.stream().map(x -> "--><li>"+=x+="</li><!--").toList()} -->
			${empty requestScope.errors? "" : "</ul></p>"}
			<label>
				<span>Product Name: </span>
				<input id="name" type="text" name="name" value="${form.name}">
			</label>
			<label>
				<span>Product Image: </span>
				<input type="file" name="files[0]" />
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