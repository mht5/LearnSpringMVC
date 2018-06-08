<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ page isELIgnored="true" %> --%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>EL</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<h1>EL</h1>
		<div class="columns">
			<div class="column col-6">
				${header["host"]}&nbsp;
				${header.host}<br/>
				${pageContext["request"]["servletPath"]}&nbsp;
				${pageContext["request"].servletPath}&nbsp;
				${pageContext.request.servletPath}&nbsp;
				${pageContext.request["servletPath"]}<br/>
				${pageContext.session.id}<br/>
				${pageContext.request.method}<br/>
				${header["accept-language"]}<br/>
				${header.connection}<br/>
				${headerValues["accept-language"][0]}<br/>
				
				${1 * 2}&nbsp;
				${1 / 2}&nbsp;
				${1 % 2}&nbsp;
				${1 + 2}&nbsp;
				${1 - 2}<br/>
				
				${1 == 2}&nbsp;&nbsp;
				${1 eq 2}&nbsp;&nbsp;
				${1 != 2}&nbsp;&nbsp;
				<%-- ${1 ne 2}&nbsp;&nbsp; --%>
				${1 > 2}&nbsp;&nbsp;
				${1 gt 2}&nbsp;&nbsp;
				${1 >= 2}&nbsp;&nbsp;
				${1 ge 2}&nbsp;&nbsp;
				${1 < 2}&nbsp;&nbsp;
				${1 lt 2}&nbsp;&nbsp;
				${1 <= 2}&nbsp;&nbsp;
				${1 le 2}&nbsp;&nbsp;<br/>
				
				${true && false}&nbsp;&nbsp;
				${true and false}&nbsp;&nbsp;
				${true || false}&nbsp;&nbsp;
				${true or false}&nbsp;&nbsp;
				${!true}&nbsp;&nbsp;
				${not false}<br/>
				
				${1 < 2 ? "1 is less than 2" : "1 is not less than 2" }<br/>
				
				${1 += 2}<br/>
				
				Today is ${LocalDate.now()}<br/>
				&radic;<span style="text-decoration:overline">&nbsp;36&nbsp;</span> = ${Math.sqrt(36)},&nbsp;
				&pi; = ${Math.PI}<br/>
				
				${{1, 2, 3, 4, 5}}&nbsp;
				<%-- ${["a", "b", "c", "d", "e"]}&nbsp; --%>
				${{"Chongqing":"Chongqing", "Sichuan":"Chengdu", "Beijing":"Beijing"}}<br/>
				<%-- ${["a", "b", "c", "d", "e"][3]}&nbsp; --%>
				${{"Chongqing":"Chongqing", "Sichuan":"Chengdu", "Beijing":"Beijing"}["Sichuan"]}<br/>
				<%-- ${["a", "b", "c", "d", "e"].stream().toList()}&nbsp;
				${["a", "b", "c", "d", "e"].stream().toArray()}<br/> --%>
				${cities.stream().limit(3).toList()}&nbsp;
				${cities.stream().sorted().toList()}<br/>
				<%-- ${[1, 3, 5, 7].stream().average().get()}&nbsp;
				${[1, 3, 5, 7].stream().sum()}&nbsp;
				${[1, 3, 5, 7].stream().count()}&nbsp;
				${[1, 3, 5, 7].stream().min().get()}&nbsp;
				${[1, 3, 5, 7].stream().max().get()}<br/> --%>
				${cities.stream().map(x -> x.toUpperCase()).toList()}<br/>
				${cities.stream().filter(x -> x.startsWith("C")).toList()}<br/>
				<!-- pageContext.out.println()在tomcat可用 -->
				${cities.stream().forEach(x -> pageContext.out.println(x))}<br/>
				${String.format("%-10.2f%n", 123.456)}&nbsp;
				${d = LocalDate.now().plusDays(2);String.format("%tB %te, %tY%n", d, d, d)}
			</div>
          	<div class="column col-2">
				<table class="table table-striped table-hover">
					<!-- ${cities.stream().map(x -> " -->
					<tr><td>" += x +="</td></tr>
					<!-- ").toList()} -->
				</table>
			</div>
          	<div class="column col-2">
				<ul>
					<!-- ${cities.stream().map(x -> " --><li>" += x += "</li><!-- ").toList()} -->
				</ul>
			</div>
          	<div class="column col-2">
				${empty cities ? "" : "<ul><li>"
				+= String.join("</li><li>", cities.stream().toList())
				+= "</li></ul>"}
			</div>
		</div>
	</body>
</html>