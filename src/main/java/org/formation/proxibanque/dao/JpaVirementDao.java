package org.formation.proxibanque.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.formation.proxibanque.entity.Virement;
import org.formation.proxibanque.util.Config;

/**
 * DAO persister virement et chercher les virements
 * 
 * @author JW
 *
 */
@Stateless
public class JpaVirementDao implements IDaoVirement {

	@PersistenceContext(unitName = Config.JPA_UNIT_NAME)
	private EntityManager em;

	@Override
	public void ajoutVirement(Virement virement) throws DaoException {
		try {
			em.merge(virement.getDepart());
			em.merge(virement.getCible());

			em.persist(virement);
		} catch (Exception e) {
			throw new DaoException("Ajout d'un virement " + virement, e);

		}

	}

	@Override
	public List<Virement> getAllVirement() throws DaoException {
		try {
			return em.createNamedQuery("findAllVirements", Virement.class).getResultList();
		} catch (Exception e) {
			throw new DaoException("Erreur lors de lister tous virements ", e);

		}
	}

	@Override
	public List<Virement> getVirementByIdClient(Long idClient) throws DaoException {
		try {
			TypedQuery<Virement> query = em.createNamedQuery("findVirementByClientId", Virement.class);
			query.setParameter("clientid", idClient);

			return query.getResultList();
		} catch (Exception e) {
			throw new DaoException("Erreur lors de lister tous virements du client id=" + idClient, e);

		}
	}
}
