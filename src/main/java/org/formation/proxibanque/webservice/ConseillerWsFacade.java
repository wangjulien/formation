package org.formation.proxibanque.webservice;

import javax.ejb.EJB;

import org.formation.proxibanque.service.IConseillerService;

/**
 * Web Service REST pour conseiller a developer
 * ToDo
 * - chercher un client par id
 * - modifier/supprimer d'un client
 * - lister les clients d'un conseiller
 * 
 * @author JW
 *
 */
public class ConseillerWsFacade implements IConseillerWsFacade {
	
	@EJB
	private IConseillerService conseillerService;

	public ConseillerWsFacade() {
		super();
	}
	
	
	
	
	
}
