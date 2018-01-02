package service;

import java.util.List;

import dao.DaoException;
import entity.Agence;
import entity.Client;
import entity.Conseiller;

public interface IGerantService {
	
	public Conseiller chercherConseiller(Long idConseiller) throws DaoException;
	
	public void ajouterConseiller(Conseiller conseiller) throws DaoException;

	public void modifierConseiller(Conseiller conseiller) throws DaoException;

	public void supprimerConseiller(Conseiller conseiller) throws DaoException;

	public List<Conseiller> listerTousClientsDuGerant(Long idGerant) throws DaoException;

	public boolean faireAudite(Agence a, List<Client> listDebiteurs);
}
