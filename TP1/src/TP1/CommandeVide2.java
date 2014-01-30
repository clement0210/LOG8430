package TP1;

import java.io.File;

public class CommandeVide2 extends CommandeFichier {
	
	public CommandeVide2(Invocateur invocateur,File fichier) {
		super(invocateur,fichier);
        setTypeFichier(TypeFichier.FICHIER);
	}

	public void executer() throws CommandeException {
        if (this.isExecutable()) {
            System.out.println("Commande Vide 2 lancé");

        }
        else {
            throw new CommandeException("Impossible d'appliquer la commande sur "+fichier);
        }
	}

}