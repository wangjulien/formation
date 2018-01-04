package test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.service.ConseillerService;
import org.formation.proxibanque.service.IConseillerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.Assert;

@RunWith(Suite.class)
@SuiteClasses({ TestVirement.class })
public class AllTests {


		IConseillerService conseillerService = new ConseillerService();
		
//		@BeforeClass
//		public static void montageClasse()
//		{
//			System.out.println("Montage avec tous test");
//		}   
		@Test
		void testAccesBD() {
		
		Client client;
		try {
			client = conseillerService.chercherClient(3L);
			assertTrue(client.getNom().equals("WANG"));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
		@Test
		void testCollectionClient(){
		List<Client> list;
		try {
			list = conseillerService.listerClientsDeConseiller(2L);
			for (Client c :list)
			{System.out.println(c);
			}
			
			Assert.assertEquals(6, list.size());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
