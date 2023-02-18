<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all Game Nights</title>
</head>
<body>
	<form method="post" action="gameNightNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allGameNights}" var="currentGameNight">
			<tr>
				<td><input type="radio" name="id" value="${currentGameNight.id}"></td>
				<td><h2>${currentGameNight.theme}</h2></td>
			</tr>
			<tr>
				<td colspan="3"> Game Night: ${currentGameNight.night} </td>
			</tr>
			<tr>
				<td colspan="3"> Family Hosting: ${currentGameNight.family.family} </td>
			</tr>
				<td colspan="3"> Games to be played: </td>
				<c:forEach var="games" items="${currentGameNight.listOfGames}">
				<tr>
					<td></td>
					<td colspan="3">
						~${games.name}: ${games.type } game with max of ${games.numOfPlayers}
					</td>
				</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="Edit" name="doThisToGame">
		<input type="submit" value="Delete" name="doThisToGame">
		<input type="submit" value="Add" name="doThisToGame">
	</form> <br />
	<a href="viewAllGamesServlet">View the complete list of games</a> <br/>
</body>
</html>