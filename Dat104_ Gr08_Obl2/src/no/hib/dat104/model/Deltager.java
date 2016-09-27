package no.hib.dat104.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "deltagere", name = "deltager")
public class Deltager implements Comparable<Deltager> {

	@Id
	private int mobil;
	private String fnavn;
	private String enavn;
	private String kjonn;
	private boolean betalingsstatus;

	public Deltager() {
		this(11111111, "Navn", "Navnesen", "M");
	}

	public Deltager(int mobil, String fnavn, String enavn, String kjonn) {
		this.mobil = mobil;
		this.fnavn = fnavn;
		this.enavn = enavn;
		this.kjonn = kjonn;
		this.betalingsstatus = false;
	}

	@Override
	public boolean equals(Object obj) {
		boolean eq = true;
		if (!(obj instanceof Deltager)) eq = false;
		else {
			Deltager d = (Deltager) obj;
			if (mobil != d.getMobil()) eq = false;
		}
		return eq;
	}

	public int getMobil() {
		return mobil;
	}

	public void setMobil(int mobil) {
		this.mobil = mobil;
	}
	
	public String getFullnavn() {
		return fnavn.concat(" ").concat(enavn);
	}

	public String getFnavn() {
		return fnavn;
	}

	public void setFnavn(String fnavn) {
		this.fnavn = fnavn;
	}

	public String getEnavn() {
		return enavn;
	}

	public void setEnavn(String enavn) {
		this.enavn = enavn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public boolean isBetalingsstatus() {
		return betalingsstatus;
	}

	public void setBetalingsstatus(boolean betalingsstatus) {
		this.betalingsstatus = betalingsstatus;
	}

	@Override
	public int compareTo(Deltager d1) {
		return enavn.compareTo(d1.getEnavn());
	}

}
