<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kasserer login</title>
</head>
<body>
	<h2>Kasserer login</h2>
	<form action="Kassererlogin" method="post">
		<fieldset>
			<legend>Kasserer login</legend>
			<p>
				Passord: <input type="password" name="passord" value="" />
			</p>
			${riktigpassord != null && !riktigpassord ? "<p><font color='red'>Feil passord</font></p>" : " " }
			<p>
				<input type="submit" value="Logg inn" />
			</p>
		</fieldset>
	</form>

</body>
</html>