package org.formation.proxibanque.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.dao.IDaoConseiller;
import org.formation.proxibanque.entity.Employee;

/**
 * Gestion de l'authentification utilisateur
 * 
 * 
 * @author JW
 *
 */

@Stateless
public class LoginService implements ILoginService {

	@EJB
	private IDaoConseiller mDaoConseiller;


	public LoginService() {
		super();
	}


	/**
	 * Retourne le premier conseiller de la base de donnee correspondant au login et
	 * au psw fournis en parametre renvoie null si aucun conseiller ne correspond
	 * 
	 * @param login
	 *            du conseiller
	 * @param psw
	 *            du conseiller
	 * @return Conseiller 
	 * 				le conseiller trouve ou null
	 * @throws DaoException
	 *             la requete a achouee
	 */
	public Employee login(String login, String psw) throws DaoException {
		Employee em = mDaoConseiller.selectEmployeeByLogin(login, psw);

		return em;
	}

}
