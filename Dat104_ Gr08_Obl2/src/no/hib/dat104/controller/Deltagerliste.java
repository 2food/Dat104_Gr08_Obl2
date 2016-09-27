package no.hib.dat104.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat104.model.Deltager;
import no.hib.dat104.model.DeltagerEAO;

@WebServlet("/Deltagerliste")
public class Deltagerliste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerEAO deao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		List<Deltager> dlist = deao.alleDeltagere();
		request.setAttribute("dlist", dlist);
		
		request.getRequestDispatcher("WEB-INF/jsp/deltagerliste.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
