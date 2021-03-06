package TP2.test;

import org.junit.Before;
import org.junit.Test;

import TP2.CommandeVide1;
import TP2.Invocateur;

import java.io.File;

public class CommandeVide1Test {

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
		System.out.println( "\tCommandeVide1: testExecuter()" );
		org.junit.Assert.assertTrue( "CommandeVide1: Le fichier est mal initialisé", commande.getFichier().toString() == PATH  );
	}
}
