package no.hib.dat104;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Innlogging
 */
@WebServlet("/Innlogging")
public class Innlogging extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjontemp = request.getSession(false);
		if (sesjontemp != null) {
			sesjontemp.invalidate();
		}
		HttpSession sesjon = request.getSession();
		sesjon.setAttribute("validmobil", true);
		request.getRequestDispatcher("WEB-INF/jsp/mobillogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("mobil") == null || request.getParameter("mobil").trim() == "") {
			HttpSession sesjon = request.getSession();
			sesjon.setAttribute("validmobil", false);
			request.getRequestDispatcher("WEB-INF/jsp/mobillogin.jsp").forward(request, response);
		} else {
			//Legg til kode for innlogging
			System.out.println("YAYYY");
		}
	}
}
