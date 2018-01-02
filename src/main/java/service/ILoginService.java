package service;

import dao.DaoException;
import entity.Employee;

public interface ILoginService {
	
	public Employee login(String login, String psw) throws DaoException ;
}
