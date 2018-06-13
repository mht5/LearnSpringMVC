<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Book List</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<h1>Book List</h1>
		<a href="<c:url value='/input-book' />">Add Book</a>
		<table class="table table-striped table-hover">
			<thead>
		    	<tr>
		      		<th>Category</th>
		      		<th>Title</th>
		      		<th>ISBN</th>
		      		<th>Author</th>
		      		<th>Price</th>
		      		<th>&nbsp;</th>
		    	</tr>
		  	</thead>
		  	<tbody>
		  		<c:forEach items="${books}" var="book">
			    	<tr class="active">
			      		<td>${book.category.name}</td>
			      		<td>${book.title}</td>
			      		<td>${book.isbn}</td>
			      		<td>${book.author}</td>
			      		<td>${book.price}</td>
			      		<td><a href="edit-book/${book.id}">Edit</a></td>
			    	</tr>
		  		</c:forEach>
		  	</tbody>
		</table>
	</body>
</html>