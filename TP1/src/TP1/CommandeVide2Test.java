package TP1;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class CommandeVide2Test {

	private static final String PATH = "C:\\workspace";
	private CommandeVide2 commande;
	
	@Before
	public void setUp() throws Exception 
	{
		commande = new CommandeVide2( new Invocateur(), new File( PATH ) );
	}

	@Test
	public void testExecuter() 
	{
		System.out.println( "\tCommandeVide2: testExecuter()" );
		org.junit.Assert.assertTrue( "CommandeVide2: Le fichier est mal initialisé", commande.getFichier().toString() == PATH  );
	}
}