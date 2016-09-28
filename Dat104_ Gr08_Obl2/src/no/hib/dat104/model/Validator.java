package no.hib.dat104.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import no.hib.dat104.javabeans.PaameldingJavaBean;

public class Validator {

	/**
	 * tester om en streng er et gyldig telefonnummer, som kan parses til int
	 * 
	 * @param nr
	 * @return boolean
	 */
	public static boolean mobilValidate(String nr) {
		boolean valid = true;
		if (nr == null || nr.length() != 8) {
			valid = false;
		} else {
			try {
				int i = Integer.parseInt(nr);
				if (i > 99999999 || i < 10000000) {
					valid = false;
				}
			} catch (Exception e) {
				valid = false;
			}
		}

		return valid;
	}

	/*
	 * Tester om string er gyldig mobilnummer og finnes i databasen.
	 * 
	 * @param nr
	 * 
	 * @param List<Deltager>
	 * 
	 * @return boolean
	 */
	public static boolean deltagerValidate(PaameldingJavaBean deltager, HttpServletRequest request, DeltagerEAO deao) {
		boolean valid = true;
		if (!navnValidate(deltager.getFornavn())) {
			request.setAttribute("ugyldigfornavn", true);
			valid = false;
		}
		if (!navnValidate(deltager.getEtternavn())) {
			request.setAttribute("ugyldigetternavn", true);
			valid = false;
		}
		if (!mobilValidate(deltager.getMobil())) {
			request.setAttribute("ugyldigmobil", true);
			valid = false;
		}
		if (deltager.getKjonn() == null) {
			valid = false;
		}
		if (finnesValidate(deltager.getMobil(), deao)) {
			request.setAttribute("finnes", true);
			valid = false;

		}
		return valid;

	}

	public static boolean finnesValidate(String mobil, DeltagerEAO deao) {
		try {
			int nr = Integer.parseInt(mobil);
			return deao.mobilEksisterer(nr);
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean navnValidate(String navn) {
		return (navn.length() <= 20 && navn.length() >= 2 && Character.isUpperCase(navn.charAt(0)));
	}

}
