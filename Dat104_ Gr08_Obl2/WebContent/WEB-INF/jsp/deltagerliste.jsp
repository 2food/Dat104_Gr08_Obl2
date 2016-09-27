<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltagerliste</title>
</head>
<c:set var="betalt" scope="page" value="#ffffff"/>
<c:set var="ubetalt" scope="page" value="#ffaaaa"/>
<c:set var="mann" scope="page" value="&#9794;"/>
<c:set var="kvinne" scope="page" value="&#9792;"/>
<body>
	<h2>Deltagerliste</h2>
	<table border="1">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
		</tr>
		<c:forEach var="d" items="${dlist}">
			<tr bgcolor="${d.betalingsstatus ? betalt : ubetalt }">
			<td align="center">${d.kjonn == "F" ? kvinne : mann }</td><td>${d.fullnavn}</td></tr>
		</c:forEach> 
		
		
		<!-- <tr bgcolor="#aaffaa"><td align="center">&#9794;</td><td>Arne Arnesen</td></tr> -->
	</table>
	<p>
		<a href="Logut">Ferdig</a>
	</p>
</body>
</html>