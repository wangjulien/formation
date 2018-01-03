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


	public List<Conseiller> selectAllByGerantId(Long idGerant) throws DaoException;

	public Employee selectEmployeeByLogin(String login, String psw) throws DaoException;
}
