package org.formation.proxibanque.service;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.entity.Employee;

public interface ILoginService {
	
	public Employee login(String login, String psw) throws DaoException ;
}
