package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Agence;
import util.Config;

/**
 * Class DAO client qui utilise les statement prepares CRUD et interface
 * generique
 * 
 * @author JW NH
 *
 */

@Stateless
public class JpaAgenceDao extends AbstractJpaDao<Agence> implements IDaoAgence {
	
	@PersistenceContext(unitName = Config.JPA_UNIT_NAME)
	private EntityManager em;

	public JpaAgenceDao() {

	}

	@Override
	public Agence getElementById(Long k) throws DaoException {
		try {
			return em.find(Agence.class, k);
		} catch (Exception ex) {
			throw new DaoException("Chercher agence par id=" + k, ex);
		}

	}

	@Override
	public List<Agence> getAllElement() throws DaoException {
		try {
			return em.createNamedQuery("findAllAgence", Agence.class).getResultList();
		} catch (Exception ex) {
			throw new DaoException("Chercher tous agences", ex);
		}
	}
}
