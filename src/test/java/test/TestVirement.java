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
//	IConseillerService conseillerService = new ConseillerService();
	
//	@EJB
//	private IConseillerService conseillerService;

//	@BeforeClass
//	public static void montageClasse()
//	{
//		System.out.println("Montage avec tous tests");
//	}  
//	
//	 @Test
//		public void testSetNomClient() {
//			 ClientParticulier client =new ClientParticulier();
//			 client.setNom("Douglas");
//			 assertTrue(client.getNom().equals("Douglas"));
//			 
//		 }
//	 
	@Test
	public void testAccesBD() throws DaoException {
		JpaClientDao daoClient =new JpaClientDao();
		Client client = daoClient.getElementById(3L);
		assertTrue(client.getNom().equals("WANG"));
	
	}
//	@Test
//	public void testFaireVirement() {
//		//public boolean faireVirement(Client debiteur, Compte depart, Client crediteur, Compte cible, double montant)
//	IVirementService virementService=new VirementService();
//	ClientParticulier debiteur=new ClientParticulier();
//	ClientParticulier crediteur=new ClientParticulier();
//	CompteCourant depart = new CompteCourant();
//	CompteCourant cible = new CompteCourant();
//	debiteur.setCompteCourant(depart);
//	crediteur.setCompteCourant(cible);
//	depart.setSolde(500.00);
//	cible.setSolde(600.00);
//	double montant=100;
//	try {
//		boolean b=virementService.faireVirement(debiteur, depart, crediteur, cible, montant);
//		Assert.assertFalse(montant<0);
//		Assert.assertEquals(true, b);
//	} catch (DaoException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	
//	
//		
//		
//		
//	}
//	
//	
//	@Test
//	public void testCollectionClient(){
//	 
//	try {
//		List<Client>list = conseillerService.listerClientsDeConseiller(2L);
//		for (Client c :list)
//		{System.out.println(c);
//		}
//		
//		Assert.assertEquals(6, list.size());
//	} catch (DaoException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	}
//	@Test
//	void testCheckMontant() {
//		Compte courant =conseillerService.chercherClient(4L).getCompteCourant();
//		
//		courant
//		
//	}
	
}
