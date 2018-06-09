<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
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
		<form:form commandName="employee" method="post" action="save-employee">
			<fieldset>
				<legend>Add an employee</legend>
				<p>
					<label for="firstName">First Name: </label>
					<form:input path="firstName" />
				</p>
				<p>
					<label for="lastName">Last Name: </label>
					<form:input path="lastName" />
				</p>
				<p><form:errors path="birthDate" cssClass="text-error" /></p>
				<p>
					<label for="birthDate">Date of Birth: </label>
					<form:input path="birthDate" />
				</p>
				<p>
					<label for="salaryLevel">Salary Level: </label>
					<form:input type="number" step="any" path="salaryLevel" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset" value="Reset">
					<input type="submit" type="submit" value="Add Employee">
				</p>
			</fieldset>
		</form:form>
	</body>
</html>