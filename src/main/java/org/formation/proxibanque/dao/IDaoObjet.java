package org.formation.proxibanque.dao;

import java.util.List;

/**
 * Definir les methodes CRUD emplyees par les DAO qui l'implementent
 * 
 * @author JW
 *
 */
public interface IDaoObjet<T> {

	/**
	 * ajouter un objet dans une persistence
	 * 
	 * @param t : un objet generique
	 */
	public void addElement(T t) throws DaoException;

	/**
	 * reuperer un objet depuis une persistence
	 * 
	 * @param k : le dedeement
	 * @return un objet generique
	 */
	public T getElementById(Long k) throws DaoException;

	/**
	 * reuperer tous objet depuis une persistence
	 * 
	 * @return un ArrayList d'objets
	 */
	public List<T> getAllElement() throws DaoException;

	/**
	 * modifier un objet dans une persistence
	 * 
	 * @param t : l'objet modifie et enresigtrer
	 */
	public T updateElement(T t) throws DaoException;

	/**
	 * supprimer un objet dans une persistence
	 * 
	 * @param t : l'objet a supprimer
	 */
	public void deleteElement(T t) throws DaoException;
}
