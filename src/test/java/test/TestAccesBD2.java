package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.service.ConseillerService;
import org.formation.proxibanque.service.IConseillerService;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class TestAccesBD2 {

	@Test
	public void testCollectionClient() {
		IConseillerService conserv = new ConseillerService();

		try {
			List<Client> list = conserv.listerClientsDeConseiller(2L);
			for (Client c : list) {
				System.out.println(c);
			}

			Assert.assertEquals(6, list.size());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
