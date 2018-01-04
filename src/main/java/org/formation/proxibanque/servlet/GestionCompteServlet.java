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
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.service.IConseillerService;
import org.formation.proxibanque.util.Config;
import org.jboss.logging.Logger;

/**
 * Servlet implementation class GestionCompteServlet
 * Il fournit les services : activer un compte non active, modifier un compte active
 * 
 * @author JW
 * 
 */

@WebServlet("/GestionCompteServlet")
public class GestionCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Config.LOG_HANDLER);
	
	@EJB
	private IConseillerService conseillerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionCompteServlet() {
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

			String paramIdClient = request.getParameter("id");
			String paramTypeCompte = request.getParameter("type");

			// activation de compte
			if (null != paramIdClient && null != paramTypeCompte) {

				Long idClient = Long.parseLong(paramIdClient);
				session.setAttribute("idclient", idClient);

				Client client = conseillerService.chercherClient(idClient);

				if ("courant".equals(paramTypeCompte)) {
					request.setAttribute("compteCourant", client.getCompteCourant());
				} else if ("epargne".equals(paramTypeCompte)) {
					request.setAttribute("compteEpargne", client.getCompteEpargne());
				}
			} else {
				// gestion de compte

				request.setAttribute("clientList", ((Conseiller) session.getAttribute("user")).getClientsList());
			}

			request.getRequestDispatcher("header.jsp").include(request, response);
			request.getRequestDispatcher("WEB-INF/compte_update.jsp").include(request, response);

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

			Long idClient = (Long) session.getAttribute("idclient");
			String paramTypeCompte = request.getParameter("type");

			Client client = conseillerService.chercherClient(idClient);

			if ("courant".equals(paramTypeCompte)) {
				client.getCompteCourant().setEtatActif(true);
				client.getCompteCourant().setNumCompte(request.getParameter("numcompte"));
				client.getCompteCourant().setSolde(Double.parseDouble(request.getParameter("solde")));
				client.getCompteCourant().setDecouvertAuthorise(Double.parseDouble(request.getParameter("decouvert")));

			} else if ("epargne".equals(paramTypeCompte)) {
				client.getCompteEpargne().setEtatActif(true);
				client.getCompteEpargne().setNumCompte(request.getParameter("numcompte"));
				client.getCompteEpargne().setSolde(Double.parseDouble(request.getParameter("solde")));
				client.getCompteEpargne().setTauxInteret(Double.parseDouble(request.getParameter("taux")));
			}

			// mettre a jour client, y compris le compte
			conseillerService.modifierClient(client);

			request.setAttribute("msg", "Activation de compte reussi");
			request.getRequestDispatcher("ShowClientsServlet").include(request, response);
	
		} catch (DaoException e) {
			String msg = "Probleme en requetant la database : " + e.getMessage() + " veuillez vous reessayer";
			request.setAttribute("msg", msg);
			logger.error(msg);
			
			request.getRequestDispatcher("ShowClientsServlet").forward(request, response);
		}
	}
}
