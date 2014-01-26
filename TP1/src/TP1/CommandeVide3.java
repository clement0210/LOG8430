package TP1;

import java.io.File;

public class CommandeVide3 extends CommandeFichier {

	public CommandeVide3(Invocateur invocateur,File fichier) {
		super(invocateur,fichier);
	}

	public void executer() {
		System.out.println("Comamnde Vide 3");
	}

}