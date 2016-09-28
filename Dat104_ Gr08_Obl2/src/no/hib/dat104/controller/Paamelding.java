package no.hib.dat104.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.openjpa.persistence.EntityExistsException;

import no.hib.dat104.javabeans.PaameldingJavaBean;
import no.hib.dat104.model.Deltager;
import no.hib.dat104.model.DeltagerEAO;
import no.hib.dat104.model.Validator;

@WebServlet("/Paamelding")
public class Paamelding extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerEAO deao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjontemp = request.getSession(false);
		if (sesjontemp != null) {
			sesjontemp.invalidate();
		}
		HttpSession sesjon = request.getSession();
		sesjon.setAttribute("deltager", new PaameldingJavaBean());
		request.setAttribute("ugyldigfornavn", false);
		request.setAttribute("ugyldigetternavn", false);
		request.setAttribute("finnes", false);
		request.setAttribute("ugyldigmobil", false);
		request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession();
		PaameldingJavaBean deltager = (PaameldingJavaBean) sesjon.getAttribute("deltager");
		deltager.setFornavn(request.getParameter("fornavn"));
		deltager.setEtternavn(request.getParameter("etternavn"));
		deltager.setMobil(request.getParameter("mobil"));
		deltager.setKjonn(request.getParameter("kjonn"));

		boolean valid = Validator.deltagerValidate(deltager, request, deao);

		if (valid) {
			Deltager d = new Deltager(Integer.parseInt(deltager.getMobil()), deltager.getFornavn(),
					deltager.getEtternavn(), deltager.getKjonn());
			
				deao.leggTilDeltager(d);
				sesjon.setAttribute("login", deltager.getMobil());
				response.sendRedirect("Bekreftelse");
		
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request, response);
		}
	}

	
}
