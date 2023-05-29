<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="super">
	<h1>Burger Tracker</h1>
	<table>
		<thead>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating(out of 5)</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var = "burger" items = "${ burgers }">
			<tr>
				<td><c:out value="${ burger.name}"/></td>
				<td><c:out value="${ burger.restaurant}"/></td>
				<td><c:out value="${ burger.rating}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Add a Burger:</h2>
	<form:form class="form" action="/new/Burger" method = "post" modelAttribute="burger">
		<div class="add" id = "add1">
			<form:label path="name">Burger Name</form:label>
			<form:errors class="error" path = "name"/>
			<form:input path="name"/>
		</div>
		<div class="add" id = "add2">
			<form:label path="restaurant">Restaurant Name</form:label>
			<form:errors class="error" path = "restaurant"/>
			<form:input path="restaurant"/>
		</div>
		<div class="add" id = "add3">
			<form:label path="rating">Rating</form:label>
			<form:errors class="error" path = "rating"/>
			<form:input path="rating"/>
		</div>
		<div class="add" id = "add4">
			<form:label path="notes">Notes</form:label>
			<form:errors class="error" path = "notes"/>
			<form:input path="notes"/>
		</div >
		<div class = "add" id = "add5">
			<input class="btn" id ="submit" type = "submit" value="Submit"/>
		</div>
	</form:form>
</div>
</body>
</html>