package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Client;
import entity.ClientEntreprise;
import entity.ClientParticulier;
import util.Config;

/**
 * Class DAO client qui utilise les statement prepares CRUD et interface
 * generique
 * 
 * @author JW NH FJA
 *
 */

@Stateless
public class JpaClientDao extends AbstractJpaDao<Client> implements IDaoClient {

	@PersistenceContext(unitName = Config.JPA_UNIT_NAME)
	private EntityManager em;

	public JpaClientDao() {

	}

	@Override
	public Client getElementById(Long k) throws DaoException {
		try {
			return em.find(Client.class, k);
		} catch (Exception ex) {
			throw new DaoException("Chercher client par id=" + k, ex);
		}
	}

	@Override
	public List<Client> getAllElement() throws DaoException {
		try {
			return em.createNamedQuery("findAllClients", Client.class).getResultList();
		} catch (Exception ex) {
			throw new DaoException("Chercher tous clients", ex);
		}
	}

	@Override
	public List<Client> selectAllClientByConseillerId(Long idConseiller) throws DaoException {
		try {
			TypedQuery<Client> query = em.createNamedQuery("findClientsByConseillerId", Client.class);
			query.setParameter("conid", idConseiller);
			return query.getResultList();
		} catch (Exception ex) {
			throw new DaoException("Chercher tous clients dont conseiller id=" + idConseiller, ex);
		}
	}

	@Override
	public List<ClientParticulier> selectAllParticulierClientByConseillerId(Long idConseiller) throws DaoException {
		try {
			TypedQuery<ClientParticulier> query = em.createNamedQuery("findParticulierClientsByConseillerId", ClientParticulier.class);
			query.setParameter("conid", idConseiller);
			return query.getResultList();
		} catch (Exception ex) {
			throw new DaoException("Chercher tous clients particulier dont conseiller id=" + idConseiller, ex);
		}
	}

	@Override
	public List<ClientEntreprise> selectAllEntrepriseClientByConseillerId(Long idConseiller) throws DaoException {
		try {
			TypedQuery<ClientEntreprise> query = em.createNamedQuery("findEntrepriseClientsByConseillerId", ClientEntreprise.class);
			query.setParameter("conid", idConseiller);
			return query.getResultList();
		} catch (Exception ex) {
			throw new DaoException("Chercher tous clients entreprise dont conseiller id=" + idConseiller, ex);
		}
	}
}
