package no.hib.dat104.model;

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

	

	public static boolean navnValidate(String navn) {
		return (navn.length() <= 20 && navn.length() >= 2 && Character.isUpperCase(navn.charAt(0)));
	}

}
