package test;

import java.util.List;

import javax.ejb.EJB;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.dao.JpaClientDao;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.ClientParticulier;
import org.formation.proxibanque.entity.Compte;
import org.formation.proxibanque.entity.CompteCourant;
import org.formation.proxibanque.service.IConseillerService;
import org.formation.proxibanque.service.IVirementService;
import org.formation.proxibanque.service.VirementService;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

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
	

