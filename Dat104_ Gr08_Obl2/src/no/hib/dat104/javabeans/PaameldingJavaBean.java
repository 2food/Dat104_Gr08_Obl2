package no.hib.dat104.javabeans;

import java.io.Serializable;

import no.hib.dat104.model.Validator;

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
		if (!Validator.mobilValidate(mobil)) {
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
