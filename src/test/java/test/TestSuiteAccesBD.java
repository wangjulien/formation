package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.Compte;
import org.formation.proxibanque.service.ConseillerService;
import org.formation.proxibanque.service.IConseillerService;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

@RunWith(Suite.class)
@SuiteClasses({
	TestAccesBD1.class,
	TestAccesBD2.class
})
public class TestSuiteAccesBD {
	
}
