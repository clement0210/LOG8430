package TP1;

import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class CommandeFichierTest {

	private static final String PATH = "C:\\workspace";
	private CommandeVide1 commande;
	
	@Before
	public void setUp() throws Exception 
	{
		commande = new CommandeVide1( new Invocateur(), new File( PATH ) );
	}

	@Test
	public void testExecuter() 
	{
		System.out.println( "\tCommandeFichier: testExecuter()" );
		org.junit.Assert.assertTrue( "CommandeVide1: Le fichier est mal initialisé", commande.getFichier().toString() == PATH  );
	}
}
