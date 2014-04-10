package test;

import TP2.CommandeVide3;
import TP2.Invocateur;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class CommandeVide3Test {

	private static final String PATH = "C:\\workspace";
	private CommandeVide3 commande;
	
	@Before
	public void setUp() throws Exception 
	{
		commande = new CommandeVide3( new Invocateur(), new File( PATH ) );
	}

	@Test
	public void testExecuter() 
	{
		System.out.println( "\tCommandeVide3: testExecuter()" );
		org.junit.Assert.assertTrue( "CommandeVide3: Le fichier est mal initialisé", commande.getFichier().toString() == PATH  );
	}
}
