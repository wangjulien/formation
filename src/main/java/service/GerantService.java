package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.DaoException;
import dao.IDaoConseiller;
import entity.Agence;
import entity.Client;
import entity.ClientEntreprise;
import entity.ClientParticulier;
import entity.CompteCourant;
import entity.Conseiller;
import util.Config;

/**
 * Classe qui regroupe tous les traitements concernant un Gerant courrant. -
 * Ajouter un conseiller Audit
 * 
 * mDaoAgence est utilise ici pour Chercher ou Modifier l'information dans
 * persistance *
 * 
 * @author JW NH
 *
 */

@Stateless
public class GerantService implements IGerantService {

	@EJB
	private IDaoConseiller mDaoConseiller;

	public GerantService() {
		super();
	}

	@Override
	public Conseiller chercherConseiller(Long idConseiller) throws DaoException {
		return mDaoConseiller.getElementById(idConseiller);
	}

	@Override
	public void ajouterConseiller(Conseiller conseiller) throws DaoException {
		mDaoConseiller.addElement(conseiller);

		// Strategy local de generer reference conseiller automatique
		if (conseiller.getRefEmployee().isEmpty())
			conseiller.setRefEmployee(Config.PREFIX_CONS_REF + conseiller.getId());

		mDaoConseiller.updateElement(conseiller);
	}

	@Override
	public void modifierConseiller(Conseiller conseiller) throws DaoException {
		mDaoConseiller.updateElement(conseiller);
	}

	@Override
	public void supprimerConseiller(Conseiller conseiller) throws DaoException {
		mDaoConseiller.deleteElement(conseiller);
	}

	@Override
	public List<Conseiller> listerTousClientsDuGerant(Long idGerant) throws DaoException {
		return mDaoConseiller.selectAllByGerantId(idGerant);
	}

	/**
	 * Methode d'audit sur un agence selon les regle,
	 * 
	 * @param a
	 *            : l'agence a auditer
	 * @param listDebiteurs
	 *            : liste de debiteurs
	 * @return : si audit est reussi (pas de debiteur) ou pas
	 */
	@Override
	public boolean faireAudite(Agence a, List<Client> listDebiteurs) {

		boolean hasDebiteurs = false;

		for (Conseiller con : a.getGerant().getConseillerList()) {
			for (Client clt : con.getClientsList()) {

				if (clt instanceof ClientParticulier
						&& clt.getCompteCourant().getSolde() < CompteCourant.MAXI_DECOUVERT_PARTICULIER) {
					listDebiteurs.add(clt);
					hasDebiteurs = true;
				}
				if (clt instanceof ClientEntreprise
						&& clt.getCompteCourant().getSolde() < CompteCourant.MAXI_DECOUVERT_ENTREPRISE) {
					listDebiteurs.add(clt);
					hasDebiteurs = true;
				}

			}
		}

		return !hasDebiteurs;
	}

}
