package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Gerant;
import service.IGerantService;

/**
 * Servlet implementation class ShowClientsServlet
 */
@WebServlet("/ShowConseillersServlet")
public class ShowConseillersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IGerantService gerantService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowConseillersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		// Liste de conseiller de ce gerant est deja charge lors de 
		Gerant gerant = (Gerant) session.getAttribute("user");

		request.setAttribute("conseillerList", gerant.getConseillerList());

		request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("WEB-INF/conseiller_show_all.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
