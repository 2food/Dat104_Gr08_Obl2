package no.hib.dat104;

import java.io.Serializable;

public class PaameldingJavaBean implements Serializable{

	private static final long serialVersionUID = -2961280658254867857L;
	private String fornavn;
	private String etternavn;
	private String mobil;
	private String kjonn; 
	
	public PaameldingJavaBean() {
		this(null,null,null,"");
	}
	
	public PaameldingJavaBean(String fornavn, String etternavn, String mobil, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.kjonn = kjonn;
	}
	
	public boolean valid() {
		boolean valid = true;
		if (fornavn == null || fornavn.trim() == "") {
			valid = false;
		}
		if (etternavn == null || etternavn.trim() == "") {
			valid = false;
		}
		if (mobil== null || mobil.trim() == "") {
			valid = false;
		}
		if (kjonn == null || kjonn.trim() == "") {
			valid = false;
		}
		return valid;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

}
