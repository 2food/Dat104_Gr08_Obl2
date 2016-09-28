<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Betalingsoversikt</title>
</head>
<c:set var="betalt" scope="page" value="#aaffaa" />
<c:set var="ubetalt" scope="page" value="#ffaaaa" />
<c:set var="mann" scope="page" value="&#9794;" />
<c:set var="kvinne" scope="page" value="&#9792;" />
<body>
	<h2>Betalingsoversikt</h2>
	<form action="Betalingsoversikt" method="post">
		<table border="1">
			<tr bgcolor="#cccccc">
				<th align="left">Navn</th>
				<th>Mobil</th>
				<th>Betalingsstatus</th>
			</tr>


			<c:forEach var="d" items="${dlist}">
				<tr bgcolor="${d.betalingsstatus ? betalt : ubetalt}">
					<td>${d.fnavn}${d.enavn}</td>
					<td>${d.mobil}</td>
					<td><c:choose>
							<c:when test="${d.betalingsstatus == true}">
								Betaling mottatt
							</c:when>
							<c:otherwise>
								<input type='submit' name='${d.mobil}'
									value='Registrer betaling' />
							</c:otherwise>
						</c:choose></td>
					<!--  <td align="center">${d.betalingsstatus ? 'Betaling mottatt' : ('<input type="submit" name="${d.mobil}"
					value="Registrer betaling" />') }</td> -->
				</tr>
			</c:forEach>
			<c:out value="sdfdf"></c:out>

		</table>
	</form>
	<p>
		<a href="Logut">Ferdig</a>
	</p>
</body>
</html>