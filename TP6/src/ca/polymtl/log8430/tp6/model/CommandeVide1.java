package ca.polymtl.log8430.tp6.model;

import java.io.File;

/**
 * Classe representant la commande vide 1 sur un fichier
 */
public class CommandeVide1 extends CommandeFichier {

    /**
     * Constrcuteur de CommandeVide1
     * @param invocateur un invocateur
     * @param fichier un fichier
     */
	public CommandeVide1(Invocateur invocateur,File fichier) {
		super(invocateur,fichier);
		setTypeFichier(TypeFichier.DOSSIER);
	}


    /**
     * Methode d'execution de la commande
     * @throws CommandeException Problème lors de l'exécution
     */
	public void executer() throws CommandeException {
		if (this.isExecutable()) {
			System.out.println("Commande Vide 1 lancé");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
        else {
            throw new CommandeException("Impossible d'appliquer la commande sur "+fichier);
        }
	}

}