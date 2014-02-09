package TP2;

import java.io.File;

/**
 * Classe representant la commande vide 3 sur un fichier
 */
public class CommandeVide3 extends CommandeFichier {


    /**
     * Constrcuteur de CommandeVide3
     * @param invocateur un invocateur
     * @param fichier un fichier
     */
	public CommandeVide3(Invocateur invocateur,File fichier) {
		super(invocateur,fichier);
        setTypeFichier(TypeFichier.FICHIERETDOSSIER);
	}

    /**
     * Methode d'execution de la commande
     * @throws CommandeException Problème lors de l'exécution
     */
	public void executer() throws CommandeException {
        if (this.isExecutable()) {
            System.out.println("Commande Vide 3 lancé");

        }
        else {
            throw new CommandeException("Impossible d'appliquer la commande sur "+fichier);
        }
	}

}