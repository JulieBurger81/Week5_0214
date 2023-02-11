<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Game</title>
</head>
<body>
	<form action="editGameServlet" method="post">
		Game's Name: <input type="text" name="name" value="${gameToEdit.name}">
		Type of Game: <input type="text" name="type" value="${gameToEdit.type}">
		Max number of Players: <input type="number" name="numOfPlayers" value="${gameToEdit.numOfPlayers}">
		<input type="hidden" name="ID"	value="${gameToEdit.id}">
		<input type="submit" value="Save Edited Item">
	</form>
</body>
</html>