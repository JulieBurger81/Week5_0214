<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new Game Night</title>
</head>
<body>
	<form action="addGameNightServlet" method="post">
	Game Night Theme: <input type="text" name="theme"><br />
	
	Game Night: <input type="text" name="month" placeholder="mm" size="4"> 
				<input type="text" name="day" placeholder="dd"	size="4">
				<input type="text" name="year" placeholder="yyyy" size="4"><br />
				
	Family member hosting: <input type="text" name="family"><br />
	
	Games to play: <br />
	<select name="allGames" multiple size="6">
		<c:forEach items="${requestScope.allGames}" var="currentgame">
			<option value="${currentgame.id}">${currentgame.name} | ${currentgame.type} | ${currentgame.numOfPlayers}</option>
		</c:forEach>
	</select>
	<br />
	<input type="submit" value="Add Game Night with Games">
	</form>
	<a href = "index.html"> Add new games to play.</a>
</body>
</html>