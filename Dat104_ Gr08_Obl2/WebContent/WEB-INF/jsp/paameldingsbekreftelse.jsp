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
		&nbsp;&nbsp;&nbsp;${deltager.fornavn}<br /> &nbsp;&nbsp;&nbsp;${deltager.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${deltager.mobil}<br /> &nbsp;&nbsp;&nbsp;${deltager.kjonn}
	</p>
	<p>
		<b>NB! Husk � betale til kassereren f�r festen!</b>
	</p>
	<a href="Deltagerliste">G� til deltagerlisten</a>
</body>
</html>