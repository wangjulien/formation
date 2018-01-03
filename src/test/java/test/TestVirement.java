package test;

import java.util.List;

import javax.ejb.EJB;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoException;
import dao.JpaClientDao;
import entity.Client;
import entity.ClientParticulier;
import entity.Compte;
import entity.CompteCourant;
import junit.framework.Assert;
import junit.framework.TestCase;
import service.IConseillerService;
import service.IVirementService;
import service.VirementService;

public class TestVirement extends TestCase {
	@Test
	public void testFaireVirement() {
		//public boolean faireVirement(Client debiteur, Compte depart, Client crediteur, Compte cible, double montant)
	IVirementService virementService=new VirementService();
	ClientParticulier debiteur=new ClientParticulier();
	ClientParticulier crediteur=new ClientParticulier();
	CompteCourant depart = new CompteCourant();
	CompteCourant cible = new CompteCourant();
	debiteur.setCompteCourant(depart);
	crediteur.setCompteCourant(cible);
	depart.setSolde(500.00);
	cible.setSolde(600.00);
	double montant=100;
	try {
		boolean b=virementService.faireVirement(debiteur, depart, crediteur, cible, montant);
		Assert.assertFalse(montant<0);
		Assert.assertEquals(true, b);
	} catch (DaoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
//	
//	@Test
//	void testCheckMontant() {
//		Compte courant =conseillerService.chercherClient(4L).getCompteCourant();
//		
//		courant
//		
//	}
	

