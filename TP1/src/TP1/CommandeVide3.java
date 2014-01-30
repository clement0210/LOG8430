package TP1;

import java.io.File;

public class CommandeVide3 extends CommandeFichier {

	public CommandeVide3(Invocateur invocateur,File fichier) {
		super(invocateur,fichier);
        setTypeFichier(TypeFichier.FICHIERETDOSSIER);
	}

	public void executer() throws CommandeException {
        if (this.isExecutable()) {
            System.out.println("Commande Vide 3 lancé");

        }
        else {
            throw new CommandeException("Impossible d'appliquer la commande sur "+fichier);
        }
	}

}