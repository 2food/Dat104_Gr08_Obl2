<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�melding</title>
</head>
<body>
	<h2>P�melding</h2>
	<form action="Paamelding" method="post">
		<fieldset>
			<legend>Personlige data</legend>
			<p>
				Fornavn: <input type="text" name="fornavn"
					value="${deltaker.fornavn}" />
			</p>
			${deltaker.fornavn.trim() == "" ? "<p><font color='red'>Kan ikke v�re tomt</font></p>" : " " }
			<p>
				Etternavn: <input type="text" name="etternavn"
					value="${deltaker.etternavn}" />
			</p>
			${deltaker.etternavn.trim() == "" ? "<p><font color='red'>Kan ikke v�re tomt</font></p>" : " " }
			<p>
				Mobil (8 siffer): <input type="text" name="mobil"
					value="${deltaker.mobil}" />
			</p>
			${deltaker.mobil.trim() == "" ? "<p><font color='red'>Kan ikke v�re tomt</font></p>" : " " }
			<p>
				Kj�nn: <input type="radio" name="kjonn" value="mann"
					${deltaker.kjonn == "mann" ? "checked='checked'" : " " } />mann <input type="radio" name="kjonn"
					value="kvinne" ${deltaker.kjonn == "kvinne" ? "checked='checked'" : " " } />kvinne
			</p>
			${deltaker.kjonn == null ? "<p><font color='red'>Et kj�nn m� velges</font></p>" : " " }
			<p>
				<input type="submit" value="Meld meg p�" />
			</p>
		</fieldset>
	</form>
</body>
</html>