package no.hib.dat104.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Kassererlogin
 */
@WebServlet(name = "Kassererlogin", urlPatterns = "/Kassererlogin")
public class Kassererlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String initpassord;
	
	@Override
	public void init() throws ServletException {
		initpassord = getServletConfig().getInitParameter("passord");
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjontemp = request.getSession(false);
		if (sesjontemp != null) {
			sesjontemp.invalidate();
		}
		request.getRequestDispatcher("WEB-INF/jsp/kassererlogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passord = request.getParameter("passord");
		HttpSession sesjon = request.getSession();
		if (passord != null && passord.equals(initpassord)) {
			sesjon.setAttribute("riktigpassord", true);
			response.sendRedirect("Betalingsoversikt");
		} else {
			sesjon.setAttribute("riktigpassord", false);
			request.getRequestDispatcher("WEB-INF/jsp/kassererlogin.jsp").forward(request, response);
		}
	}

}
