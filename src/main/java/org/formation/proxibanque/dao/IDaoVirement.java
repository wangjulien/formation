package org.formation.proxibanque.dao;

import java.util.List;

import org.formation.proxibanque.entity.Virement;

/**
 * Interface de persister virement
 * 
 * @author JW
 *
 */
public interface IDaoVirement {
	
	public void ajoutVirement(Virement virement) throws DaoException;

	public List<Virement> getAllVirement() throws DaoException ;

	public List<Virement> getVirementByIdClient(Long idClient) throws DaoException ;
}
