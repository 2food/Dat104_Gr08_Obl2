<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�meldingsbekreftelse</title>
</head>
<body>
	<h2>P�meldingsbekreftelse</h2>
	<p>P�meldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${deltaker.fornavn}<br /> &nbsp;&nbsp;&nbsp;${deltaker.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${deltaker.mobil}<br /> &nbsp;&nbsp;&nbsp;${deltaker.kjonn}
	</p>
	<p>
		<b>NB! Husk � betale til kassereren f�r festen!</b>
	</p>
	<a href="Deltakerliste">G� til deltagerlisten</a>
</body>
</html>