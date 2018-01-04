package org.formation.proxibanque.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.entity.Employee;
import org.formation.proxibanque.entity.Gerant;
import org.formation.proxibanque.util.Config;

/**
 * Class DAO client qui utilise les statement prepares CRUD et interface
 * generique
 * 
 * @author JW
 *
 */

@Stateless
public class JpaConseillerDao extends AbstractJpaDao<Conseiller> implements IDaoConseiller {

	@PersistenceContext(unitName = Config.JPA_UNIT_NAME)
	private EntityManager em;

	public JpaConseillerDao() {

	}

	@Override
	public Conseiller getElementById(Long k) throws DaoException {
		try {
			Conseiller con = em.find(Conseiller.class, k);
			con.getClientsList().size();
			return con;
		} catch (Exception ex) {
			throw new DaoException("Chercher conseiller par id=" + k, ex);
		}
	}

	@Override
	public List<Conseiller> getAllElement() throws DaoException {
		try {
			return em.createNamedQuery("findAllConseiller", Conseiller.class).getResultList();
		} catch (Exception ex) {
			throw new DaoException("Chercher tous les conseillers", ex);
		}

	}

	@Override
	public List<Conseiller> selectAllByGerantId(Long idGerant) throws DaoException {
		try {
			TypedQuery<Conseiller> query = em.createNamedQuery("findConseillersByGerandId", Conseiller.class);
			query.setParameter("gerid", idGerant);
			return query.getResultList();
		} catch (Exception ex) {
			throw new DaoException("Chercher tous conseillers dont gerant id=" + idGerant, ex);
		}
	}

	@Override
	public Employee selectEmployeeByLogin(String login, String psw) throws DaoException {
		try {
			TypedQuery<Employee> query = em.createQuery(
					"select m from Employee m " + "where m.login = :login and m.password = :psw", Employee.class);
			query.setParameter("login", login);
			query.setParameter("psw", psw);
			
			Employee em = query.getSingleResult();
			
			// charger client/conseiller list pour conseiller/gerant
			if (em instanceof Conseiller)
				((Conseiller)em).getClientsList().size();
			else if (em instanceof Gerant)
				((Gerant)em).getConseillerList().size();

			return em;

		} catch (Exception ex) {
			throw new DaoException("Chercher un employee par login=" + login + " et psw=" + psw, ex);
		}
	}

}
