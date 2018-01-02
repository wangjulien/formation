package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoException;
import entity.Adresse;
import entity.Client;
import entity.ClientEntreprise;
import entity.ClientParticulier;
import entity.Conseiller;
import service.IConseillerService;

/**
 * Servlet implementation class UpdateClientServlet
 */
@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IConseillerService conseillerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateClientServlet() {
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

			String paramId = request.getParameter("id");

			// mettre a jour d'un client
			if (null != paramId) {

				Long idClient = Long.parseLong(paramId);

				Client client = conseillerService.chercherClient(idClient);

				session.setAttribute("client", client);
			} else {
				// sinon creation d'un nouveau client
				session.removeAttribute("client");
			}

			request.getRequestDispatcher("header.jsp").include(request, response);
			request.getRequestDispatcher("WEB-INF/client_update.jsp").include(request, response);

		} catch (DaoException e) {
			request.setAttribute("msg",
					"Probleme en requetant la database : " + e.getMessage() + " veuillez vous reessayer");
			request.getRequestDispatcher("ShowClientsServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession(false);

			Client client = (Client) session.getAttribute("client");

			// mettre a jour d'un client
			if (null != client) {

				client.setRefClient(request.getParameter("ref"));
				client.setPrenom(request.getParameter("prenom"));
				client.setNom(request.getParameter("nom"));
				client.getAdresse().setRue(request.getParameter("rue"));
				client.getAdresse().setCodePostal(Integer.parseInt(request.getParameter("codepostal")));
				client.getAdresse().setVille(request.getParameter("ville"));
				client.getAdresse().setTel(request.getParameter("tel"));

				conseillerService.modifierClient(client);

				request.getRequestDispatcher("header.jsp").include(request, response);

				request.setAttribute("msg", "Client mis a jour");
				request.getRequestDispatcher("WEB-INF/client_update.jsp").include(request, response);
			} else { // ajouter un nouvea client

				if ("particulier".equals(request.getParameter("typeclient"))) {
					client = new ClientParticulier();
				} else {
					client = new ClientEntreprise();
				}

				client.setRefClient(request.getParameter("ref"));
				client.setPrenom(request.getParameter("prenom"));
				client.setNom(request.getParameter("nom"));

				Adresse adresse = new Adresse(request.getParameter("rue"),
						Integer.parseInt(request.getParameter("codepostal")), request.getParameter("ville"),
						request.getParameter("tel"));
				client.setAdresse(adresse);

				Conseiller conseiller = (Conseiller) session.getAttribute("user");
				conseiller.addClient(client);

				conseillerService.ajouterClient(client);

				request.setAttribute("msg", "Nouveau client ajoute");
				response.sendRedirect("UpdateClientServlet?id=" + client.getId());
			}

		} catch (DaoException e) {
			request.setAttribute("msg",
					"Probleme en requetant la database : " + e.getMessage() + " veuillez vous reessayer");
			request.getRequestDispatcher("ShowClientsServlet").forward(request, response);
		}
	}

}
