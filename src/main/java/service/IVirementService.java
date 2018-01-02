package service;

import dao.DaoException;
import entity.Client;
import entity.Compte;


public interface IVirementService {

	public boolean faireVirement(Client debiteur, Compte depart, Client crediteur, Compte cible, double montant) throws DaoException;

}
