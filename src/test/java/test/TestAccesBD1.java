package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.DaoException;
import dao.JpaClientDao;
import entity.Client;

public class TestAccesBD1 {

	@Test
	public void testAccesBD() throws DaoException {
		JpaClientDao daoClient =new JpaClientDao();
		Client client = daoClient.getElementById(3L);
		assertTrue(client.getNom().equals("WANG"));

	}
}
