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
import entity.Adresse;
import entity.Conseiller;
import entity.Gerant;
import service.IGerantService;
import util.Config;

/**
 * Servlet implementation class UpdateClientServlet
 */
@WebServlet("/UpdateConseillerServlet")
public class UpdateConseillerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Config.LOG_HANDLER);
	
	@EJB
	private IGerantService gerantService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateConseillerServlet() {
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

				Long idConseiller = Long.parseLong(paramId);

				Conseiller conseiller = gerantService.chercherConseiller(idConseiller);

				session.setAttribute("conseiller", conseiller);
			} else {
				// sinon creation d'un nouveau client
				session.removeAttribute("conseiller");
			}

			request.getRequestDispatcher("header.jsp").include(request, response);
			request.getRequestDispatcher("WEB-INF/conseiller_update.jsp").include(request, response);

		} catch (DaoException e) {
			String msg = "Probleme en requetant la database : " + e.getMessage() + " veuillez vous reessayer";
			request.setAttribute("msg", msg);
			logger.error(msg);
			
			request.getRequestDispatcher("ShowConseillersServlet").forward(request, response);
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

			Conseiller conseiller = (Conseiller) session.getAttribute("conseiller");

			// mettre a jour d'un conseiller
			if (null != conseiller) {

				conseiller.setRefEmployee(request.getParameter("ref"));
				conseiller.setPrenom(request.getParameter("prenom"));
				conseiller.setNom(request.getParameter("nom"));
				conseiller.getAdresse().setRue(request.getParameter("rue"));
				conseiller.getAdresse().setCodePostal(Integer.parseInt(request.getParameter("codepostal")));
				conseiller.getAdresse().setVille(request.getParameter("ville"));
				conseiller.getAdresse().setTel(request.getParameter("tel"));

				gerantService.modifierConseiller(conseiller);

				request.getRequestDispatcher("header.jsp").include(request, response);

				request.setAttribute("msg", "Conseiller mis a jour");
				request.getRequestDispatcher("WEB-INF/conseiller_update.jsp").include(request, response);
			} else { // ajouter un nouvea conseiller
				
				conseiller = new Conseiller();

				conseiller.setRefEmployee(request.getParameter("ref"));
				conseiller.setPrenom(request.getParameter("prenom"));
				conseiller.setNom(request.getParameter("nom"));

				Adresse adresse = new Adresse(request.getParameter("rue"),
						Integer.parseInt(request.getParameter("codepostal")), request.getParameter("ville"),
						request.getParameter("tel"));
				conseiller.setAdresse(adresse);

				Gerant gerant = (Gerant) session.getAttribute("user");
				gerant.addConseiller(conseiller);

				gerantService.ajouterConseiller(conseiller);

				request.setAttribute("msg", "Nouveau conseiller ajoute");
				response.sendRedirect("UpdateConseillerServlet?id=" + conseiller.getId());
			}

		} catch (DaoException e) {
			String msg = "Probleme en requetant la database : " + e.getMessage() + " veuillez vous reessayer";
			request.setAttribute("msg", msg);
			logger.error(msg);
			
			request.getRequestDispatcher("ShowConseillersServlet").forward(request, response);
		}
	}

}
