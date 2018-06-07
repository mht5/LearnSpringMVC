<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Employee Form</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<form:form commandName="product" method="post" action="save-product">
			<fieldset>
				<legend>Add a product</legend>
				<p><form:errors path="name" cssClass="text-error" /></p>
				<p>
					<label for="name">Product Name: </label>
					<form:input path="name" />
				</p>
				<p>
					<label for="description">Description: </label>
					<form:input path="description" />
				</p>
				<p><form:errors path="productionDate" cssClass="text-error" /></p>
				<p>
					<label for="productionDate">Production Date: </label>
					<form:input path="productionDate" />
				</p>
				<p><form:errors path="price" cssClass="text-error" /></p>
				<p>
					<label for="price">Price: </label>
					<form:input type="number" step="any" path="price" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset" value="Reset">
					<input type="submit" type="submit" value="Add Employee">
				</p>
			</fieldset>
		</form:form>
	</body>
</html>