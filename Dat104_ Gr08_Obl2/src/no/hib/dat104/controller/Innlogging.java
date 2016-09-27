package no.hib.dat104.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.model.Deltager;
import no.hib.dat104.model.DeltagerEAO;
import no.hib.dat104.model.Validator;

/**
 * Servlet implementation class Innlogging
 */
@WebServlet("/Innlogging")
public class Innlogging extends HttpServlet {
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
		sesjon.setAttribute("validmobil", true);
		sesjon.setAttribute("mobilfinnes", true);
		request.getRequestDispatcher("WEB-INF/jsp/mobillogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mobil = request.getParameter("mobil");
		HttpSession sesjon = request.getSession();
		sesjon.setAttribute("validmobil", true);
		sesjon.setAttribute("mobilfinnes", true);
		
		List<Deltager> dlist = deao.alleDeltagere();
		Validator v = new Validator();
		if (!v.mobilValidate(mobil)) {
			sesjon.setAttribute("validmobil", false);
			request.getRequestDispatcher("WEB-INF/jsp/mobillogin.jsp").forward(request, response);
		} else if (!v.loginValidate(mobil, dlist)) {
			sesjon.setAttribute("mobilfinnes", false);
			request.getRequestDispatcher("WEB-INF/jsp/mobillogin.jsp").forward(request, response);
		} else {
			sesjon.setAttribute("login", mobil);
			response.sendRedirect("Deltagerliste");
		}
	}

}
