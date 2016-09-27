package no.hib.dat104.model;

import java.util.List;

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
	public static boolean loginValidate(String nr, List<Deltager> dlist) {
		if (nr == null) {
			return false;
		} else {
			boolean valid = true;
			boolean finnes = false;
			for (Deltager d : dlist) {
				if (d.getMobil() == Integer.parseInt(nr)) {
					finnes = true;
				}
			}
			if (!mobilValidate(nr) || !finnes) {
				valid = false;
			}
			return valid;
		}
	}
}
