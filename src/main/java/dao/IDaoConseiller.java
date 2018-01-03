package dao;

import java.util.List;

import entity.Conseiller;
import entity.Employee;

/**
 * Gestion des Conseillers
 * 
 * @author JW NH
 *
 */
public interface IDaoConseiller extends IDaoObjet<Conseiller> {

	/**
	 * Renvoi liste des conseillers de l'agence dont l'identifiant est passe en
	 * parametre
	 * 
	 * @param idAgence
	 * @return List ou null
	 */
	public List<Conseiller> selectAllByGerantId(Long idGerant) throws DaoException;

	/**
	 * Renvoie le Employee dont le login et le mode de passe sont fourni en
	 * parametre, null sinon
	 * 
	 * @param login
	 * @param psw
	 * @return Employee ou null
	 * @throws DaoException
	 *             la requete a echouee
	 */
	public Employee selectEmployeeByLogin(String login, String psw) throws DaoException;
}
