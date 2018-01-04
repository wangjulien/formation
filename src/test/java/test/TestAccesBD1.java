package test;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.dao.JpaClientDao;
import org.formation.proxibanque.entity.Client;
import org.junit.jupiter.api.Test;

public class TestAccesBD1 {

	@Test
	public void testAccesBD() throws DaoException {
		JpaClientDao daoClient =new JpaClientDao();
		Client client = daoClient.getElementById(3L);
		assertTrue(client.getNom().equals("WANG"));

	}
}
