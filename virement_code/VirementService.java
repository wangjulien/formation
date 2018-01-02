package org.formation.proxibanque_jw.service;

/**
 * Service realisant des Virements d'un Compte a un autre
 * 
 * @author JW NH
 *
 */

//@Stateless
public class VirementService {
	
//	@EJB
//	private IDaoCompte daoCompte;
//	
//	@EJB
//	private IDaoVirement daoVirement;
//
//	public VirementService() {
//		super();
//	}
//
//
//	
//	public boolean faireVirement(Client debiteur, Compte depart, Client crediteur, Compte cible, double montant) throws DaoException {
//		if (checkMontantSolde(depart, montant)) {
//
//			// Insertion de virement dans table
//			daoVirement.insertVirement(new Virement(depart.getNumCompte(), cible.getNumCompte(), montant));
//
//			depart.setSolde(depart.getSolde() - montant);
//			cible.setSolde(cible.getSolde() + montant);
//
//			// modification de table compte
//			daoCompte.updateCompte(depart);
//			daoCompte.updateCompte(cible);
//
//			return true;
//		} else
//			return false;
//	}
//	
//
//	/**
//	 * Verifie que le montant ne depasse pas le solde du compte
//	 * 
//	 * @param depart    le compte a verifier
//	 * @param montant	le montant � virer
//	 * @return true si le solde est suffisant
//	 */
//	private boolean checkMontantSolde(Compte depart, double montant) {
//		// TODO
//		if ((depart.getSolde() >= montant)
//			 || (depart instanceof CompteCourant && ((CompteCourant) depart).getDecouvertAuthorise() + depart.getSolde() >= montant))
//			return true;
//		else
//			return false;
//	}

}