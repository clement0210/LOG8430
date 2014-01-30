package TP1;

import java.io.File;

public class CommandeVide1 extends CommandeFichier {

	public CommandeVide1(Invocateur invocateur,File fichier) {
		super(invocateur,fichier);
		setTypeFichier(TypeFichier.DOSSIER);
	}

	public void executer() throws CommandeException {
		if (this.isExecutable()) {
			System.out.println("Commande Vide 1 lancé");
		}
        else {
            throw new CommandeException("Impossible d'appliquer la commande sur "+fichier);
        }
	}

}