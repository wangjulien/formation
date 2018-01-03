package webservice;

import javax.ejb.EJB;

import service.IConseillerService;

/**
 * Web Service REST pour conseiller a developer
 * ToDo
 * - chercher un client par id
 * - modifier/supprimer d'un client
 * - lister les clients d'un conseiller
 * 
 * @author JW NH
 *
 */
public class ConseillerWsFacade {
	
	@EJB
	private IConseillerService conseillerService;
	
	
}
