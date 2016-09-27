package no.hib.dat104.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeltagerEAOtest
 */
@WebServlet("/DeltagerEAOtest")
public class DeltagerEAOtest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private DeltagerEAO deao;
	
	private Deltager d0 = new Deltager(55550000, "Test", "Testsen", "M");


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out= response.getWriter();
		
		
		//legg til og fjern
		deao.leggTilEllerOppdater(d0);
		out.println("d0 eksisterer:" + deao.deltagerEksisterer(d0) + "<br>");
		deao.slettDeltager(d0.getMobil());
		out.println("d0 eksisterer ikke lengre:" + !deao.deltagerEksisterer(d0) + "<br>");
		
		//oppdater betaling
		deao.leggTilEllerOppdater(d0);
		out.println("d0 har betalt:" + deao.finnDeltager(d0.getMobil()).isBetalingsstatus() + "<br>");
		deao.oppdaterBetalingsstatus(d0.getMobil(), true);
		out.println("d0 har betalt:" + deao.finnDeltager(d0.getMobil()).isBetalingsstatus() + "<br>");
		
		
		
		
		deao.slettDeltager(d0.getMobil());
		
		

	}




}
