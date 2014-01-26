package TP1;

import java.io.File;

public class CommandeVide1 extends CommandeFichier {

	public CommandeVide1(Invocateur invocateur,File fichier) {
		super(invocateur,fichier);
		setTypeFichier(TypeFichier.DOSSIER);
	}

	public void executer() {
		System.out.println("Comamnde Vide 1");
		File[] files=getFichier().listFiles();
		for(File file:files){
			System.out.println("\t"+file.getName());
		}
	}

}