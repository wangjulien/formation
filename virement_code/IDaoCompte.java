package org.formation.proxibanque_jw.dao;

import org.formation.proxibanque_jw.domain.entity.Compte;

/**
 * Gestion des Comptes
 * 
 * @author JW NH
 *
 */
public interface IDaoCompte {
		
	public void updateCompte(Compte c) throws DaoException ;
}
