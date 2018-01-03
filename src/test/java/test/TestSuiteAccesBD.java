package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoException;
import entity.Client;
import entity.Compte;
import junit.framework.Assert;
import junit.framework.TestCase;
import service.ConseillerService;
import service.IConseillerService;

@RunWith(Suite.class)
@SuiteClasses({
	TestAccesBD1.class,
	TestAccesBD2.class
})
public class TestSuiteAccesBD {
	
}
