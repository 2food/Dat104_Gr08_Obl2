package no.hib.dat104.controller;

import java.io.IOException;
import java.util.ArrayList;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DeltagerEAO deao = new DeltagerEAO();
		ArrayList<Deltager> dlist = (ArrayList<Deltager>) deao.alleDeltagere();
		request.setAttribute("dlist", dlist);
		
		request.getRequestDispatcher("WEB-INF/jsp/deltagerliste.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
