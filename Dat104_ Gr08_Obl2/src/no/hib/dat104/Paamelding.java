package no.hib.dat104;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Paamelding")
public class Paamelding extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjontemp = request.getSession(false);
		if (sesjontemp != null) {
			sesjontemp.invalidate();
		}
		HttpSession sesjon = request.getSession();
		sesjon.setAttribute("deltaker", new PaameldingJavaBean());
		request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession();
		PaameldingJavaBean deltaker = (PaameldingJavaBean) sesjon.getAttribute("deltaker");
		deltaker.setFornavn(request.getParameter("fornavn"));
		deltaker.setEtternavn(request.getParameter("etternavn"));
		deltaker.setMobil(request.getParameter("mobil"));
		deltaker.setKjonn(request.getParameter("kjonn"));
		request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request, response);
		
	}

}
