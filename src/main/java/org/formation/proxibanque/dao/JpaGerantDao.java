package org.formation.proxibanque.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
public class JpaGerantDao extends AbstractJpaDao<Gerant> implements IDaoGerant {

	@PersistenceContext(unitName = Config.JPA_UNIT_NAME)
	private EntityManager em;

	public JpaGerantDao() {

	}

	@Override
	public Gerant getElementById(Long k) throws DaoException {
		try {
			return em.find(Gerant.class, k);
		} catch (Exception ex) {
			throw new DaoException("Chercher un gerant par id=" + k, ex);
		}

	}

	@Override
	public List<Gerant> getAllElement() throws DaoException {
		try {
			return em.createNamedQuery("findAllAgence", Gerant.class).getResultList();
		} catch (Exception ex) {
			throw new DaoException("Chercher tous les gerants", ex);
		}

	}
}
