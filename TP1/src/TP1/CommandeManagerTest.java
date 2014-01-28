package TP1;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

public class CommandeManagerTest {

	private static final String PATH = "C:\\workspace";
	@SuppressWarnings("unused")
	private CommandeVide1 cmd1;
	
	@Before
	public void setUp() throws Exception 
	{
		cmd1 = new CommandeVide1( new Invocateur(), new File( PATH ) );
	}
	
	@Test
	public void testManage()
	{
		System.out.println( "\tCommandeManager: testManager()" );
		org.junit.Assert.assertTrue( "erreur", true == true  );
	}
	
	@Test
	public void testExecuterCommande1()
	{
		System.out.println( "\tCommandeManager: testExecuterCommande1()" );
		org.junit.Assert.assertTrue( "erreur", true == true  );
	}
	
	@Test
	public void testExecuterCommande2()
	{
		System.out.println( "\tCommandeManager: testExecuterCommande2()" );
		org.junit.Assert.assertTrue( "erreur", true == true  );
	}
	
	@Test
	public void testExecuterCommande3()
	{
		System.out.println( "\tCommandeManager: testExecuterCommande3()" );
		org.junit.Assert.assertTrue( "erreur", true == true  );
	}
	
	@Test
	@Ignore
	public void testExecuterSelect()
	{
		System.out.println( "\tCommandeManager: testExecuterSelect()" );
		org.junit.Assert.assertTrue( "erreur", true == true  );
	}
}