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
					value="${deltager.fornavn}" />
			</p>
			${ugyldigfornavn ? "<p><font color='red'>Ugyldig fornavn. M� v�re mellom 2-20 bokstaver og begynne med stor bokstav.</font></p>" : " " }
			<p>
				Etternavn: <input type="text" name="etternavn"
					value="${deltager.etternavn}" />
			</p>
			${ugyldigetternavn ? "<p><font color='red'>Ugyldig etternavn. M� v�re mellom 2-20 bokstaver og begynne med stor bokstav.</font></p>" : " " }
			<p>
				Mobil (8 siffer): <input type="text" name="mobil"
					value="${deltager.mobil}" />
			</p>
			${finnes ? "<p><font color='red'>Deltager er allerede p�meldt</font></p>" : " "}
			${deltager.mobil.trim() == "" ? "<p><font color='red'>Kan ikke v�re tomt</font></p>" : " " }
			${ugyldigmobil ? "<p><font color='red'>Ugyldig mobilnummer</font></p>" : " "}
			<p>
				Kj�nn: <input type="radio" name="kjonn" value="M"
					${deltager.kjonn == "M" ? "checked=\"checked\"" : " " } />mann <input type="radio" name="kjonn"
					value="F" ${deltager.kjonn == "F" ? "checked=\"checked\"" : " " } />kvinne
			</p>
			${deltager.kjonn == null ? "<p><font color='red'>Et kj�nn m� velges</font></p>" : " " }
			<p>
				<input type="submit" value="Meld meg p�" />
			</p>
		</fieldset>
	</form>
</body>
</html>