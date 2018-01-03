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
import dao.IDaoVirement;
import entity.Conseiller;
import entity.Virement;
import service.IConseillerService;

/**
 * Servlet implementation class ShowVirement
 * Il fournit la service de lister les virement d'un client selectionne
 * ToDo : servlet en cours de developper 
 * 
 * @author JW NH
 * 
 */
@WebServlet("/ShowVirement")
public class ShowVirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private IDaoVirement daoVirement;
       private IConseillerService conseillerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowVirementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			HttpSession session = request.getSession(false);

			Conseiller user = (Conseiller) session.getAttribute("user");
			
			// liste des clients du conseiller logger
			request.setAttribute("clientList", user.getClientsList());
			
			// tous les client de la banque
			request.setAttribute("allClientList", conseillerService.listerTousClients());

			request.getRequestDispatcher("header.jsp").include(request, response);
			request.getRequestDispatcher("WEB-INF/virement_find.jsp").include(request, response);

		} catch (DaoException e) {
			request.setAttribute("msg", "Echec de l'identification, veuillez vous reconnecter");
			request.getRequestDispatcher("LoginServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			Long idClient=Long.parseLong(request.getParameter("idClient"));
			List<Virement> virements = daoVirement.getVirementByIdClient(idClient);
			request.setAttribute("virementsList", virements);
			request.getRequestDispatcher("header.jsp").include(request, response);
			request.getRequestDispatcher("WEB-INF/virement_find.jsp").include(request, response);

		} catch (DaoException e) {
			request.setAttribute("msg", "Echec de l'identification, veuillez vous reconnecter");
			request.getRequestDispatcher("LoginServlet").forward(request, response);
		}
	}

}
