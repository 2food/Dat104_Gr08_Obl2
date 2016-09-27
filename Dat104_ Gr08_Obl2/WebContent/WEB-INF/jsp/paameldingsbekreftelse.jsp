<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${deltager.fornavn}<br /> &nbsp;&nbsp;&nbsp;${deltager.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${deltager.mobil}<br /> &nbsp;&nbsp;&nbsp;${deltager.kjonn}
	</p>
	<p>
		<b>NB! Husk å betale til kassereren før festen!</b>
	</p>
	<a href="Deltagerliste">Gå til deltagerlisten</a>
</body>
</html>