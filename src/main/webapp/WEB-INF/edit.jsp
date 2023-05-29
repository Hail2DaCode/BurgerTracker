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
		<h2>Edit Burger</h2>
		<a href="/">Go Back</a>
	<form:form class="form" action="/burgers/${burger.id }" method = "post" modelAttribute="burger">
	<input type = "hidden" name = "_method" value = "put">
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