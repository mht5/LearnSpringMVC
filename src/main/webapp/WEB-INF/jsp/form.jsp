<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add PDF Form</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<form method="post" action="pdf">
			<h1>Add PDF</h1>
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