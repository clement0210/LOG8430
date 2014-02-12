package TP2.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import TP2.CommandeDynamic;
import TP2.CommandeVide1;
import TP2.CommandeVide2;
import TP2.CommandeVide3;
import TP2.Invocateur;

import java.io.File;
import java.util.Map;

public class CommandeManagerTest {

	private static final String PATH = "C:\\workspace";
	private CommandeVide1 cmd1;
	private CommandeVide2 cmd2;
	private CommandeVide3 cmd3;
	private Map<Integer, CommandeDynamic> commandeFichier;
	
	@Before
	public void setUp() throws Exception 
	{
		testFillCommandeFichier( commandeFichier );
	}
	
	@Test
	@Ignore
	public void testFillCommandeFichier( Map<Integer, CommandeDynamic> commandeFichier ) throws ClassNotFoundException
	{
		Class c1 = Class.forName( "TestSuite1.class" );
		Object obj1 = null;
		CommandeDynamic cmdDyn1 = new CommandeDynamic( c1, obj1 );
		commandeFichier.put( 7, cmdDyn1 );
	}
	
	@Test
	public void testExecuterCommande( int id )
	{
		System.out.println( "\tCommandeManager: testExecuterCommande" );
		org.junit.Assert.assertTrue( "CommandeManager: Classe mal chargée", commandeFichier.get( 7 ).getClasseCommande().toString() == "TestSuite1.class" );
	}
}