package dao;

import java.util.List;

import entity.Client;
import entity.ClientEntreprise;
import entity.ClientParticulier;

/**
 * Gestion des Clients
 * 
 * @author JW NH JFA
 *
 */
public interface IDaoClient extends IDaoObjet<Client> {

	/**
	 * Renvoie la liste des clients du conseiller dont l'identifiant est fourni en
	 * parametre
	 * 
	 * @param idConseiller
	 * @return List<Client>
	 */
	public List<Client> selectAllClientByConseillerId(Long idConseiller)  throws DaoException;
	
	public List<ClientParticulier> selectAllParticulierClientByConseillerId(Long idConseiller)  throws DaoException;
	
	public List<ClientEntreprise> selectAllEntrepriseClientByConseillerId(Long idConseiller)  throws DaoException;
	
	
}
