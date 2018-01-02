package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.DaoException;
import dao.IDaoClient;
import entity.Client;
import entity.ClientEntreprise;
import entity.ClientParticulier;
import entity.Compte;
import util.Config;

/**
 * Classe qui regroupe tous les traitements concernant un Conseiller courrant.
 * 		- Ajouter un Client
 * 		- Recuperer un Client par son ID, lire toutes ces informations (data)
 * 		- Modifier un Client
 * 		- Supprimer un Client
 * 		- Lister tous les Client dans persistence
 * 		- ToDo : simulationCredit et gestionPatrimoine
 * 
 * DaoClient est utilise ici pour Chercher ou Modifier l'information dans persistance
 *  * 
 * @author JW NH
 *
 */

@Stateless
public class ConseillerService implements IConseillerService {
		
	@EJB
	private IDaoClient mDaoClient;

	public ConseillerService() {
		super();
	}
	
	@Override
	public Client chercherClient(Long idClient) throws DaoException {
		return mDaoClient.getElementById(idClient);		
	}

	/**
	 * Ajout d'un client dans la persistence
	 * @param client : client a ajouter
	 * @throws DaoException 
	 */
	public void ajouterClient(Client client) throws DaoException {
		
		mDaoClient.addElement(client);
		
		// Strategy local de generer reference client automatique
		if (client.getRefClient().isEmpty())
			client.setRefClient(Config.PREFIX_CLI_REF + client.getId());
		
		mDaoClient.updateElement(client);
	}


	/**
	 * Mettre a jour un client dans la persistence
	 * @param client : le client modifie
	 * @throws DaoException 
	 */
	public void modifierClient(Client client) throws DaoException {
		mDaoClient.updateElement(client);
	}

	/**
	 * Suppression d'un client donne dans persistence
	 * @param client : le client a supprimer
	 * @throws DaoException 
	 */
	public void supprimerClient(Client client) throws DaoException {
		mDaoClient.deleteElement(client);;
	}

	/**
	 * Recupere tous les client de la persistence
	 * @return : une liste de client
	 * @throws DaoException 
	 */
	public List<Client> listerTousClients() throws DaoException {
		return mDaoClient.getAllElement();

	}
	
	/**
	 * Recupere tous les client de la persistence
	 * @return : une liste de client
	 * @throws DaoException 
	 */
	public List<Client> listerClientsDeConseiller(Long idConseiller) throws DaoException {
		return mDaoClient.selectAllClientByConseillerId(idConseiller);

	}


	@Override
	public void activerClientCompte(Client client, Compte compte) throws DaoException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ClientParticulier> listerClientsParticulierDeConseiller(Long idConseiller) throws DaoException {
		return mDaoClient.selectAllParticulierClientByConseillerId(idConseiller);
	}


	@Override
	public List<ClientEntreprise> listerClientsEntrepriseDeConseiller(Long idConseiller) throws DaoException {
		return mDaoClient.selectAllEntrepriseClientByConseillerId(idConseiller);
	}


}
