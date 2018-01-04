package org.formation.proxibanque.service;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.Compte;


public interface IVirementService {

	public boolean faireVirement(Client debiteur, Compte depart, Client crediteur, Compte cible, double montant) throws DaoException;

}
