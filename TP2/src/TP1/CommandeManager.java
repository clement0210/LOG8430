package TP1;

import java.io.File;

/**
 * Classe de controle du programme
 */
public class CommandeManager {
	
	private Invocateur invocateur;
	private File fichier;
    private CommandeFrame commandeFrame;

    /**
     * Constructeur par défaut
     */
	public CommandeManager(){
		invocateur = new Invocateur();
		fichier = new File(".");
        commandeFrame = new CommandeFrame(this);

	}

    /**
     * Méthode de manage de la vue
     */
	public void manage(){
		commandeFrame.display();
	}

    /**
     * Methode d'exécution de la commande 1
     * @return le résultat de la commande 1
     */
	public String executerCommande1() {
		CommandeVide1 commandeVide1 = new CommandeVide1(invocateur, fichier);
        try {
            commandeVide1.executer();
            return "Commande 1 sur " + fichier.getName();
        } catch (CommandeException e) {
            e.printStackTrace();
            return "Impossible d'appliquer la commande (voir le log)";
        }

	}

    /**
     * Methode d'exécution de la commande 2
     * @return le résultat de la commande 2
     */
	public String executerCommande2(){
		CommandeVide2 commandeVide2 = new CommandeVide2(invocateur, fichier);
        try {
            commandeVide2.executer();
            return "Commande 2 sur " + fichier.getName();
        } catch (CommandeException e) {
            e.printStackTrace();
            return "Impossible d'appliquer la commande (voir le log)";
        }

	}

    /**
     * Methode d'exécution de la commande 3
     * @return le résultat de la commande 3
     */
	public String executerCommande3(){
		CommandeVide3 commandeVide3 = new CommandeVide3(invocateur, fichier);
        try {
            commandeVide3.executer();
            return "Commande 3 sur " + fichier.getName();
        } catch (CommandeException e) {
            e.printStackTrace();
            return "Impossible d'appliquer la commande (voir le log)";
        }

	}

    /**
     * Methode d'exécution du selecteur de fichier
     * @return le résultat du selecteur de fichier
     */
	public String executerSelect(){
		CommandeSelecte commandeSelecte = new CommandeSelecte(invocateur);
		commandeSelecte.executer();
		fichier = commandeSelecte.getFichier();
        StringBuilder str=new StringBuilder();
        str.append("<html>"+fichier.getName()+"<br/>");
        for(File file : commandeSelecte.getContenu()){
            str.append("&nbsp;&nbsp;&nbsp;&nbsp;"+file.getName()+"<br/>");
        }
        str.append("</html>");
		return str.toString();
	}
}
