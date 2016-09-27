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

@WebServlet("/Deltagerliste")
public class Deltagerliste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerEAO deao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession();
		List<Deltager> dlist = deao.alleDeltagere();
		Validator v = new Validator();
		if (v.loginValidate((String) sesjon.getAttribute("login"), dlist)) {
			request.setAttribute("dlist", dlist);
			request.getRequestDispatcher("WEB-INF/jsp/deltagerliste.jsp").forward(request, response);
		} else {
			response.sendRedirect("Innlogging");
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
