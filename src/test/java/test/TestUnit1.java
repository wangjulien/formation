package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.ClientParticulier;

public class TestUnit1 {

	@Test
	public void testSetNomClient() {
		 ClientParticulier client =new ClientParticulier();
		 client.setNom("Douglas");
		 assertTrue(client.getNom().equals("Douglas"));
		 
	 }

}
