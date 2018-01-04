package org.formation.proxibanque.dao;

import java.util.List;

import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.entity.Employee;

/**
 * Gestion des Conseillers
 * 
 * @author JW
 *
 */
public interface IDaoConseiller extends IDaoObjet<Conseiller> {


	public List<Conseiller> selectAllByGerantId(Long idGerant) throws DaoException;

	public Employee selectEmployeeByLogin(String login, String psw) throws DaoException;
}
