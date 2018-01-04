package test;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.proxibanque.entity.CompteCourant;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestUnit2 {

	@Test
	public void testSetNumCompt() {
		
		CompteCourant cc =new CompteCourant();
		cc.setNumCompte("123456");
		Assert.assertFalse(cc.getNumCompte().equalsIgnoreCase("456789"));
	}

}
