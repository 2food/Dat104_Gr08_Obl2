package no.hib.dat104.model;

import org.junit.Before;
import org.junit.Test;

public class DeltagerEAOtest {
	
	DeltagerEAO deao;
	Deltager d0;

	@Before
	public void init() {
		deao = new DeltagerEAO();
		d0 = new Deltager(55556666,"Per", "Fjes", "M");
	}
	
	@Test
	public void leggTil() {
		
	}

}
