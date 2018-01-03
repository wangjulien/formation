package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;

import dao.DaoException;
import entity.Client;
import entity.Compte;
import entity.Conseiller;
import service.IConseillerService;
import service.IVirementService;
import util.Config;

/**
 * Servlet implementation class OperationServ
 * Il fournit la service de faire un virement compte a compte
 * 
 * @author JW NH
 *
 */

@WebServlet("/VirementServlet")
public class VirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(Config.LOG_HANDLER);
	
	@EJB
	private IVirementService virementService;

	@EJB
	private IConseillerService conseillerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VirementServlet() {
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
			
			// liste des clients du conseiller logge
			request.setAttribute("clientList", user.getClientsList());
			
			// tous les client de la banque
			request.setAttribute("allClientList", conseillerService.listerTousClients());

			request.getRequestDispatcher("header.jsp").include(request, response);
			request.getRequestDispatcher("WEB-INF/virement.jsp").include(request, response);

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
			// Pour IHM separer Client liste et Compte liste
//			Long idDebiteur = Long.parseLong(request.getParameter("debiteurselect"));
//			Long idCrediteur = Long.parseLong(request.getParameter("crediteurselect"));
//			String typeDebiteur = request.getParameter("debcomptselect");
//			String typeCrediteur = request.getParameter("crdcomptselect");
			
			String[] listeClientSelect = request.getParameter("listeClientSelect").split("-");
			Long idDebiteur = Long.parseLong(listeClientSelect[0]);
			String typeDebiteur = listeClientSelect[1];
			
			String[] listeAllClientSelect = request.getParameter("listeAllClientSelect").split("-");
			Long idCrediteur = Long.parseLong(listeAllClientSelect[0]);
			String typeCrediteur = listeAllClientSelect[1];
			
			double montant = Double.parseDouble(request.getParameter("montant"));

			Client debiteur = conseillerService.chercherClient(idDebiteur);
			Client crediteur = conseillerService.chercherClient(idCrediteur);

			Compte depart = null;
			Compte cible = null;

			if ("courant".equals(typeDebiteur))
				depart = debiteur.getCompteCourant();
			else
				depart = debiteur.getCompteEpargne();

			if ("courant".equals(typeCrediteur))
				cible = crediteur.getCompteCourant();
			else
				cible = crediteur.getCompteEpargne();

			if (virementService.faireVirement(debiteur, depart, crediteur, cible, montant)) {
				
				// logger le virement
				logger.info("Client (" + debiteur.getNom() + " " + debiteur.getPrenom() + ") " + " a effectue un virement : \n "
						+ "compte depart : " + depart.getNumCompte()
						+ "\nbeneficiaire : " + crediteur.getNom() + " " + crediteur.getPrenom() + " compte cible : " + cible.getNumCompte()
						+ "\npour un montant : " + montant);
				
				request.setAttribute("msg",	"Virement reussi");
				request.setAttribute("debiteur", debiteur);
				request.setAttribute("depart", depart);
				request.setAttribute("crediteur", crediteur);
				request.setAttribute("cible", cible);
				request.setAttribute("montant", montant);
				
				request.getRequestDispatcher("header.jsp").include(request, response);
				request.getRequestDispatcher("WEB-INF/virement.jsp").include(request, response);
				
			} else {
				request.setAttribute("msg",
						"Montant du compte debiteur insuffisant, veuillez vous reessayer");
				request.getRequestDispatcher("ShowClientsServlet").forward(request, response);
			}

		} catch (DaoException e) {
			String msg = "Probleme a persister le virement dans la database : " + e.getMessage() + " veuillez vous reessayer";
			request.setAttribute("msg", msg);
			logger.error(msg);
			
			request.getRequestDispatcher("ShowClientsServlet").forward(request, response);
		}
	}

}
