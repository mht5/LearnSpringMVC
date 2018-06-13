<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSTL</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<h1>JSTL</h1>
		<div class="columns">
			<div class="column col-5">
				<c:out value="${email}" /><br/>
				
				<img src="img1.jpg" width="30%"/>
				<img src="image/img1.jpg" width="30%"/>
				<img src="../image/img1.jpg" width="30%"/>
				<!-- url标签可以正确解析context -->
				<img src="<c:url value="/image/img1.jpg" />" width="30%"/><br/>
				
				<c:set var="firstName" value="John" />
				<c:set var="lastName">
					Doe
				</c:set>
				<c:set var="email" value="${requestScope.email}" scope="page" />
				<c:set target="${address}" property="country" value="China" />
				<c:set target="${address}" property="city">
					Chongqing
				</c:set>
				<c:out value="${firstName}" />&nbsp;
				<c:out value="${lastName}" />&nbsp;
				<c:out value="${email}" />&nbsp;
				<c:out value="${address.country}" />&nbsp;
				<c:out value="${address.city}" /><br/>
				
				<c:remove var="firstName" />
				<c:remove var="lastName" scope="page" />
				firstName = <c:out value="${firstName}" />,&nbsp;
				lastName = <c:out value="${lastName}" /><br/>
				
				<c:if test="${address.country != null}">
					country has been set.
				</c:if>&nbsp;
				<c:if var="isStateSet" test="${address.state != null}" />
				${isStateSet ? "state has been set." : "state has not been set."}&nbsp;
				<c:choose>
					<c:when test="${address.zipCode != null}">
						zip code has not been set.
					</c:when>
					<c:when test="${address.state != null}">
						state has not been set.
					</c:when>
					<c:otherwise>
						all is set.
					</c:otherwise>
				</c:choose><br/>
				
				<fmt:formatNumber value="12" type="number" />&nbsp;
				<fmt:formatNumber value="12" type="number" minIntegerDigits="3" />&nbsp;
				<fmt:formatNumber value="12" type="number" minFractionDigits="2" />&nbsp;
				<fmt:formatNumber value="123.456" pattern=".00" />&nbsp;
				<fmt:formatNumber value="123456.78" pattern="#,#00.00" />&nbsp;
				<fmt:formatNumber value="12" type="currency" />&nbsp;
				<fmt:formatNumber value="12" type="currency" currencySymbol="$" />&nbsp;
				<fmt:formatNumber value="0.12" type="percent" />&nbsp;
				<fmt:formatNumber value="0.123" type="percent" minFractionDigits="2" /><br/>
				
				<fmt:parseNumber value="12.00" type="number" />&nbsp;
				<fmt:parseNumber value="12.60" type="number" integerOnly="true" />&nbsp;
				<fmt:parseNumber value="123,456.78" type="number" pattern="#,#00.00" />&nbsp;
				<fmt:parseNumber value="￥12.00" type="currency" />&nbsp;
				<fmt:parseNumber value="12%" type="percent" />&nbsp;
				<fmt:parseNumber value="12%" type="percent" var="num" scope="page" />${num}<br/>
				
				<fmt:formatDate value="${date}" />,&nbsp;
				<fmt:formatDate value="${date}" dateStyle="short" />,&nbsp;
				<fmt:formatDate value="${date}" dateStyle="medium" />,&nbsp;
				<fmt:formatDate value="${date}" dateStyle="long" />,&nbsp;
				<fmt:formatDate value="${date}" dateStyle="full" /><br/>
				<fmt:formatDate value="${date}" type="time" />,&nbsp;
				<fmt:formatDate value="${date}" type="time" timeStyle="short" />,&nbsp;
				<fmt:formatDate value="${date}" type="time" timeStyle="medium" />,&nbsp;
				<fmt:formatDate value="${date}" type="time" timeStyle="long" />,&nbsp;
				<fmt:formatDate value="${date}" type="time" timeStyle="full" /><br/>
				<fmt:formatDate value="${date}" type="both" />,&nbsp;
				<fmt:formatDate value="${date}" type="both" dateStyle="short" timeStyle="short" />,&nbsp;
				<fmt:formatDate value="${date}" type="both" dateStyle="long" timeStyle="long" /><br/>
				<fmt:formatDate value="${date}" type="time" timeZone="CT" />,&nbsp;
				<fmt:formatDate value="${date}" type="time" timeZone="GMT+8:00" />,&nbsp;
				<fmt:formatDate value="${date}" type="both" pattern="dd-MM-yy" />,&nbsp;
				<fmt:formatDate value="${date}" type="both" pattern="dd-MM-yyyy" /><br/>
				
				<fmt:parseDate value="2018-6-9" />,&nbsp;
				<fmt:parseDate value="2018-6-9" type="date" /><br/>
				<fmt:parseDate value="2018年6月9日" dateStyle="long" />,&nbsp;
				<fmt:parseDate value="下午07时02分34秒" type="time" timeStyle="long"/><br/>
				<fmt:parseDate value="09-06-2018" type="date" pattern="dd-MM-yyyy" /><br/>
				
				<fmt:timeZone value="CST">
					<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" /><br/>
				</fmt:timeZone>
				<fmt:timeZone value="GMT+1:00">
					<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" /><br/>
				</fmt:timeZone>
				<fmt:timeZone value="GMT+1:00">
					<fmt:formatDate value="${date}" type="both" timeZone="GMT+8:00" dateStyle="full" timeStyle="full" /><br/>
				</fmt:timeZone>
				<fmt:setTimeZone value="GMT+8:00" var="GMT+8" scope="page" />
			</div>
			<div class="column col-3">
				<c:forEach var="x" begin="1" end="10" step="2">
					<c:out value="${x}" />
				</c:forEach>&nbsp;<br/>
				<c:forEach var="city" items="${cities}" varStatus="status">
					${city}, count: ${status.count}<br/>
					<c:if test="${status.last}">---------<br/></c:if>
				</c:forEach>
				<c:forEach var="capital" items="${capitals}" varStatus="status">
					The capital of ${capital.key} is ${capital.value}<br/>
					<c:if test="${status.last}">---------<br/></c:if>
				</c:forEach>
				<c:forTokens var="item" items="Chongqing,Chengdu" delims=",">
					${item}
				</c:forTokens>
			</div>
			<div class="column col-4">
				<c:set var="myString" value="hello, world" />
				${fn:contains(myString, "hello")}&nbsp;
				${fn:contains("the remains of the day", "day")}&nbsp;
				${fn:containsIgnoreCase("DO NOT GO GENTLE INTO THAT DARK NIGHT", "night")}&nbsp;
				${fn:endsWith(myString, "world")}&nbsp;
				${fn:startsWith(myString, "hello")}&nbsp;
				<c:set var="myString" value="What<br/>is this" />
				${myString}&nbsp;
				${fn:escapeXml(myString)}&nbsp;
				${fn:indexOf(myString, "this")}<br/>
				${fn:join(myArray, "-")}<br/>
				${fn:length(myString)}&nbsp;
				${fn:length(myArray)}&nbsp;
				${fn:replace("the remains of the day", 'a', '4')}<br/>
				<c:set var="splitValue" value='${fn:split("you-reap-what-you-sow", "-")}' />
				<c:forEach var="str" items="${splitValue}" varStatus="status">
					${str}<c:if test="${!status.last}">_</c:if>
				</c:forEach><br/>
				${fn:substring("the remains of the day", 4, 11)}&nbsp;
				${fn:substringBefore("the remains of the day", "of")}&nbsp;
				${fn:substringAfter("the remains of the day", "of")}<br/>
				${fn:toLowerCase("DO NOT GO GENTLE INTO THAT DARK NIGHT")}<br/>
				${fn:toUpperCase("the remains of the day")}<br/>
				*${fn:trim("   what is going on     ")}*<br/>
			</div>
		</div>
	</body>
</html>