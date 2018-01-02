package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoException;
import entity.ClientEntreprise;
import entity.ClientParticulier;
import entity.Conseiller;
import service.IConseillerService;

/**
 * Servlet implementation class ShowClientsServlet
 */
@WebServlet("/ShowClientsServlet")
public class ShowClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IConseillerService conseillerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowClientsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession(false);

			Conseiller user = (Conseiller) session.getAttribute("user");

			List<ClientParticulier> clientParticulierList = conseillerService
					.listerClientsParticulierDeConseiller(user.getId());
			request.setAttribute("clientParticulierList", clientParticulierList);

			List<ClientEntreprise> clientEntrepriseList = conseillerService
					.listerClientsEntrepriseDeConseiller(user.getId());

			request.setAttribute("clientEntrepriseList", clientEntrepriseList);

			request.getRequestDispatcher("header.jsp").include(request, response);
			request.getRequestDispatcher("WEB-INF/client_show_all.jsp").include(request, response);

		} catch (DaoException e) {
			request.setAttribute("msg", "Echec de l'identification, veuillez vous reconnecter");
			request.getRequestDispatcher("LoginServlet").include(request, response);
		}
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
