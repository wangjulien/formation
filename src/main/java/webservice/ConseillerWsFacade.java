package webservice;

import javax.ejb.EJB;

import service.IConseillerService;

public class ConseillerWsFacade {
	
	@EJB
	private IConseillerService conseillerService;
	
	
}
