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
import entity.Employee;
import service.ILoginService;
import util.Config;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Config.LOG_HANDLER);

	@EJB
	private ILoginService loginService;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("login.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String login = request.getParameter("login");
			String psw = request.getParameter("psw");

			HttpSession session = request.getSession();

			Employee user = loginService.login(login, psw);
			session.setAttribute("user", user);
			
			request.getRequestDispatcher("header.jsp").include(request, response);
			request.getRequestDispatcher("welcome.jsp").include(request, response);
			
			// logger l'utilisateur
			logger.info("Utilisateur (role " + user.getRole() + ") " + user.getNom() + " " + user.getPrenom() + " se logge.");

		} catch (DaoException e) {
			request.setAttribute("msg", "Echec de l'identification : " + e.getMessage() + "  veuillez vous reconnecter");
			request.getRequestDispatcher("header.jsp").include(request, response);
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}

}
