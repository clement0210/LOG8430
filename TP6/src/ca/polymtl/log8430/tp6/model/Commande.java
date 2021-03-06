package ca.polymtl.log8430.tp6.model;

/**
 * Interface d'une commande
 */
public interface Commande {

    /**
     * Methode d'execution de la commande
     * @throws CommandeException Problème lors de l'exécution
     */
	public void executer() throws CommandeException;

}