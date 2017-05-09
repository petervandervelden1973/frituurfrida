package be.vdab.servlets;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.SausRepository;

@WebServlet("/ingredienten.htm")
public class IngredientenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/ingredienten.jsp";
	private final SausRepository sausRepository = new SausRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ingredient = request.getParameter("ingredient");
		if (ingredient != null) {
			if (ingredient.isEmpty()) {
				request.setAttribute("fouten", Collections.singletonMap("ingredient", "verplicht"));
			} else {
				request.setAttribute("sauzen", sausRepository.findByIngredient(ingredient));
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}