package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.DaoException;
import entity.Client;
import junit.framework.Assert;
import service.ConseillerService;
import service.IConseillerService;

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
