package be.vdab.servlets;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Gemeente;

@WebServlet(urlPatterns = "/index.htm",name = "indexservlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setAttribute("telefoonnummerContact",
				request.getServletContext().getInitParameter("telefoonnummerContact"));
		LocalDate vandaag = LocalDate.now();
		DayOfWeek weekdag = vandaag.getDayOfWeek();
		request.setAttribute("openGesloten",
			weekdag == DayOfWeek.MONDAY || weekdag == DayOfWeek.THURSDAY ?
					"gesloten" : "open");
		request.setAttribute("adres", new Adres("Bodemstraat", "79/3",
				new Gemeente("Riemst", 3770)));
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);
	}
}