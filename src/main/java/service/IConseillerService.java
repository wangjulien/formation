package service;

import java.util.List;

import dao.DaoException;
import entity.Client;
import entity.ClientEntreprise;
import entity.ClientParticulier;

public interface IConseillerService {
	
	public Client chercherClient(Long idClient) throws DaoException;
	
	public void ajouterClient(Client client) throws DaoException;
	
	public void modifierClient(Client client) throws DaoException;

	public void supprimerClient(Client client) throws DaoException;

	public List<Client> listerTousClients() throws DaoException;

	public List<Client> listerClientsDeConseiller(Long idConseiller) throws DaoException;
	
	public List<ClientParticulier> listerClientsParticulierDeConseiller(Long idConseiller) throws DaoException;
	
	public List<ClientEntreprise> listerClientsEntrepriseDeConseiller(Long idConseiller) throws DaoException;
}
