package TP1;

import java.io.File;

public class CommandeVide2 extends CommandeFichier {
	
	public CommandeVide2(Invocateur invocateur,File fichier) {
		super(invocateur,fichier);
	}

	public void executer() {
		System.out.println("Comamnde Vide 2");
	}

}