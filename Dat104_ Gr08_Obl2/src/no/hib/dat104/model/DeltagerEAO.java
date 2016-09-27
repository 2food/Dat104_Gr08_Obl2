package no.hib.dat104.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DeltagerEAO {

	@PersistenceContext(name = "deltagerPU")
	private EntityManager em;
	
	/**
	 * Legger til en deltager d, eller oppdaterer den hvis den allerede eksisterer
	 * @param d
	 */
	public void leggTilEllerOppdater(Deltager d) {
		if (deltagerEksisterer(d)) {
			oppdaterDeltager(d);
		} else {
			leggTilDeltager(d);
		}
	}
	/**
	 * Sjekker om deltager d eksisterer
	 * @param d
	 * @return
	 */
	public boolean deltagerEksisterer(Deltager d) {
		boolean eksiterer = false;
		List<Deltager> dList = alleDeltagere();
		for (Deltager d2 : dList) {
			if (d.equals(d2)) eksiterer = true;
		}
		return eksiterer;
	}
	/**
	 * Legger til en deltager d
	 * @param d
	 */
	public void leggTilDeltager(Deltager d) {
		em.persist(d);
	}
	/**
	 * Returnerer en List<Deltager> over alle registrerte deltagere, sortert etter etternavn
	 * @return
	 */
	public List<Deltager> alleDeltagere() {
		TypedQuery<Deltager> query = em.createQuery("SELECT s FROM Deltager s", Deltager.class);
		List<Deltager> q =query.getResultList();
		List<Deltager> list = new ArrayList<Deltager>();
		for (Deltager d : q) {
			list.add(d);
		}
		Collections.sort(list);
		return list;
	}
	/**
	 * Setter betalingsstatus status på deltagereren registrert med nummeret mobil
	 * @param mobil
	 * @param status
	 */
	public void oppdaterBetalingsstatus(int mobil, boolean status) {
		Deltager d = finnDeltager(mobil);
		d.setBetalingsstatus(status);
		oppdaterDeltager(d);
	}
	
	/**
	 * Returnerer deltagereren registrert med nummeret mobil
	 * @param mobil
	 * @return
	 */
	public Deltager finnDeltager(int mobil) {
		return em.find(Deltager.class, mobil);
	}
	/**
	 * Oppdaterer deltagereren s
	 * @param s
	 */
	public void oppdaterDeltager(Deltager s) {
		em.merge(s);
	}
	/**
	 * Sletter deltagereren s
	 * @param s
	 */
	public void slettDeltager(int mobil) {
		em.remove(em.find(Deltager.class, mobil));
	}
	

}
