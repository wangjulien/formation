package org.formation.proxibanque.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.entity.Adresse;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.ClientEntreprise;
import org.formation.proxibanque.entity.ClientParticulier;
import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.service.IConseillerService;
import org.formation.proxibanque.util.Config;
import org.jboss.logging.Logger;

/**
 * Servlet implementation class UpdateClientServlet
 * Il fournit les services : mettre a jour les informations d'un client, ajouter un nouveau client
 * 
 * @author JW
 * 
 */
@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Config.LOG_HANDLER);
	
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
			String msg = "Probleme en requetant la database : " + e.getMessage() + " veuillez vous reessayer";
			request.setAttribute("msg", msg);
			logger.error(msg);
			
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
			String msg = "Probleme en requetant la database : " + e.getMessage() + " veuillez vous reessayer";
			request.setAttribute("msg", msg);
			logger.error(msg);
			
			request.getRequestDispatcher("ShowClientsServlet").forward(request, response);
		}
	}

}
