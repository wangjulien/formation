package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import entity.CompteCourant;

public class TestUnit2 {

	@Test
	public void testSetNumCompt() {
		
		CompteCourant cc =new CompteCourant();
		cc.setNumCompte("123456");
		Assert.assertFalse(cc.getNumCompte().equalsIgnoreCase("456789"));
	}

}
