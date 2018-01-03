package dao;

import java.util.List;

import entity.Virement;

/**
 * Interface de persister virement
 * 
 * @author JW NH
 *
 */
public interface IDaoVirement {
	
	public void ajoutVirement(Virement virement) throws DaoException;

	public List<Virement> getAllVirement() throws DaoException ;

	public List<Virement> getVirementByIdClient(Long idClient) throws DaoException ;
}
