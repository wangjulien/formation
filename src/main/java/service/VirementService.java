package service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.DaoException;
import dao.IDaoClient;
import dao.IDaoVirement;
import entity.Client;
import entity.Compte;
import entity.CompteCourant;
import entity.Virement;

/**
 * Service realisant des Virements d'un Compte a un autre
 * 
 * @author JW NH
 *
 */

@Stateless
public class VirementService implements IVirementService {

	@EJB
	private IDaoClient daoClient;

	@EJB
	private IDaoVirement daoVirement;

	public VirementService() {
		super();
	}

	/**
	 * Verifie que le montant ne depasse pas le solde du compte
	 * 
	 * @param depart
	 *            le compte a verifier
	 * @param montant
	 *            le montant a virer
	 * @return true si le solde est suffisant
	 */

	private boolean checkMontantSolde(Compte depart, double montant) {
		
		if (montant < 0)
			return false;
		else if ((depart.getSolde() >= montant) || (depart instanceof CompteCourant
				&& ((CompteCourant) depart).getDecouvertAuthorise() + depart.getSolde() >= montant))
			return true;
		else
			return false;
	}
	
	@Override
	public boolean faireVirement(Client debiteur, Compte depart, Client crediteur, Compte cible, double montant)
			throws DaoException {
		if (checkMontantSolde(depart, montant)) {

			depart.setSolde(depart.getSolde() - montant);
			cible.setSolde(cible.getSolde() + montant);

			// Insertion de virement dans table
			daoVirement.ajoutVirement(new Virement(debiteur, depart, crediteur, cible, montant));

			return true;
		} else
			return false;
	}

}