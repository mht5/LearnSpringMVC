<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edit Book Form</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<c:url var="formAction" value="/update-book" />
		<form:form commandName="book" method="post" action="${formAction}">
			<fieldset>
				<legend>Edit a book</legend>
				<form:hidden path="id" />
				<p>
					<label for="category">Category: </label>
					<form:select id="category" path="category.id"
						items="${categories}" itemLabel="name" itemValue="id" />
				</p>
				<p>
					<label for="title">Title: </label>
					<form:input id="title" path="title" />
				</p>
				<p>
					<label for="author">Author: </label>
					<form:input id="author" path="author" />
				</p>
				<p>
					<label for="isbn">ISBN: </label>
					<form:input id="isbn" path="isbn" />
				</p>
				<p>
					<label for="price">Price: </label>
					<form:input id="price" type="number" step="any" path="price" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset" value="Reset">
					<input type="submit" type="submit" value="Update Book">
				</p>
			</fieldset>
		</form:form>
	</body>
</html>