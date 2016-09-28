package no.hib.dat104.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Validatortest {

	public Deltager d0 = new Deltager(12345678, "Hei", "Sveis", "M");
	public Deltager d1 = new Deltager(12341234, "Nei", "Nese", "M");
	public Deltager d2 = new Deltager(23452345, "Geir", "Kake", "M");
	public List<Deltager> dL = new ArrayList<Deltager>();

	public String n0 = "";
	public String n1 = "Fasdlijasldijlsijdalisdjsaid";
	public String n2 = "asdlslks";
	public String n3 = "Aasdpok";
	
	public String m0 = "1234";
	public String m1 = "12sda32";
	public String m2 = "123412341";
	public String m3 = "";
	public String m4 = "12341234";
	
	@Before
	public void before() {
		dL.add(d0);
		dL.add(d1);
	}
	
	@Test
	public void navnValidate() {
		assertFalse(Validator.navnValidate(n0));
		assertFalse(Validator.navnValidate(n1));
		assertFalse(Validator.navnValidate(n2));
		assertTrue(Validator.navnValidate(n3));
	}
	@Test
	public void mobilValidate() {
		assertFalse(Validator.mobilValidate(m0));
		assertFalse(Validator.mobilValidate(m1));
		assertFalse(Validator.mobilValidate(m2));
		assertFalse(Validator.mobilValidate(m3));
		assertTrue(Validator.mobilValidate(m4));
		
	}
	

}





