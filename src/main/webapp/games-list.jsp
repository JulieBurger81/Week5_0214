<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Games List</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<input type="submit" value="Edit" name="doThisToGame">
		<input type="submit" value="Delete" name="doThisToGame">
		<input type="submit" value="Add" name="doThisToGame">
		<br/>
		List of Family Games
		<table>
			<c:forEach items="${requestScope.allGames}" var="currentgame">
				<tr>
					<td><input type="radio" name="id" value="${currentgame.id}"></td>
					<td>${currentgame.name}</td>
					<td>${currentgame.type}</td>
					<td>${currentgame.numOfPlayers}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>