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
 * Servlet implementation class Betalingsoversikt
 */
@WebServlet("/Betalingsoversikt")
public class Betalingsoversikt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerEAO deao;
	
	String initpassord;
	
	@Override
	public void init() throws ServletException {
		initpassord = getServletConfig().getInitParameter("passord");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession();
		List<Deltager> dlist = deao.alleDeltagere();
		if (true) {//sesjon.getAttribute("login") == initpassord) {
			request.setAttribute("dlist", dlist);
			request.getRequestDispatcher("WEB-INF/jsp/betalingsoversikt.jsp").forward(request, response);
		} else {
			response.sendRedirect("Kassererlogin");
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Deltager> dlist = deao.alleDeltagere();
		for (Deltager d : dlist) {
			if (request.getParameter(String.valueOf(d.getMobil())) != null) {
				deao.oppdaterBetalingsstatus(d.getMobil(), true);
			}
		}
		doGet(request, response);
	}

}
