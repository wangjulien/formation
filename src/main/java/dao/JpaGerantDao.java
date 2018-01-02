package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Gerant;

/**
 * Class DAO client qui utilise les statement prepares CRUD et interface
 * generique
 * 
 * @author JW NH FJA
 *
 */

@Stateless
public class JpaGerantDao extends AbstractJpaDao<Gerant> implements IDaoGerant {

	@PersistenceContext(unitName = "org.formation.proxibanque")
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
