package no.hib.dat104.model;

public class MobilValidator {
	/**
	 * tester om en streng er et gyldig telefonnummer, som kan parses til int
	 * @param nr
	 * @return
	 */
	public static boolean validate(String nr) {
		boolean valid = true;
		if (nr.length() != 8) {
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

}
