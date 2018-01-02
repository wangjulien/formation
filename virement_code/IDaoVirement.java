package org.formation.proxibanque_jw.dao;

import org.formation.proxibanque_jw.domain.entity.Virement;

public interface IDaoVirement {
	public void insertVirement(Virement virement) throws DaoException;
}
