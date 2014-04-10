import java.io.File;

/**
 * Classe representant la commande vide 2 sur un fichier
 */
public class CommandeVide2 extends CommandeFichier {

    /**
     * Constrcuteur de CommandeVide2
     * @param invocateur un invocateur
     * @param fichier un fichier
     */
	public CommandeVide2(Invocateur invocateur,File fichier) {
		super(invocateur,fichier);
        setTypeFichier(TypeFichier.FICHIER);
	}

    /**
     * Methode d'execution de la commande
     * @throws CommandeException Problème lors de l'exécution
     */
	public void executer() throws CommandeException {
        if (this.isExecutable()) {
            System.out.println("Commande Vide 2 lancé");

        }
        else {
            throw new CommandeException("Impossible d'appliquer la commande sur "+fichier);
        }
	}

}