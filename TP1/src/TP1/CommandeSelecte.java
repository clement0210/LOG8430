package TP1;

import java.io.File;

public class CommandeSelecte extends CommandeFichier {
	
	public CommandeSelecte(Invocateur invocateur) {
		super(invocateur,null);
	}

	public void executer() {
		File fichier = new File(invocateur.getNomFichier());
		setFichier(fichier);
	}

}
