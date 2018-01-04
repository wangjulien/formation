package org.formation.proxibanque.dao;

import java.util.List;

import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.ClientEntreprise;
import org.formation.proxibanque.entity.ClientParticulier;

/**
 * Gestion des Clients
 * 
 * @author JW
 *
 */
public interface IDaoClient extends IDaoObjet<Client> {

	/**
	 * Renvoie la liste des clients du conseiller dont l'identifiant est fourni en
	 * parametre
	 * 
	 * @param idConseiller
	 * @return List
	 */
	public List<Client> selectAllClientByConseillerId(Long idConseiller)  throws DaoException;
	
	public List<ClientParticulier> selectAllParticulierClientByConseillerId(Long idConseiller)  throws DaoException;
	
	public List<ClientEntreprise> selectAllEntrepriseClientByConseillerId(Long idConseiller)  throws DaoException;
	
	
}
