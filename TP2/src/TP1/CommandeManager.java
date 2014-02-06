package TP1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe de controle du programme
 */
public class CommandeManager {
	
	private Invocateur invocateur;
	private File fichier;
    private CommandeFrame commandeFrame;
    private Map<Integer,CommandeFichier> commandeFichierMap;
    /**
     * Constructeur par défaut
     */
	public CommandeManager(){
		invocateur = new Invocateur();
		fichier = new File(".");
        commandeFichierMap=new HashMap<Integer, CommandeFichier>();
        fillCommandeFichierMap(commandeFichierMap);
        commandeFrame = new CommandeFrame(this);

	}

    public Map<Integer, CommandeFichier> getCommandeFichierMap() {
        return commandeFichierMap;
    }

    public void setCommandeFichierMap(Map<Integer, CommandeFichier> commandeFichierMap) {
        this.commandeFichierMap = commandeFichierMap;
    }

    /**
     * Méthode de manage de la vue
     */
	public void manage(){
		commandeFrame.display();
	}

    /**
     * Methode d'exécution de la commande
     * @return le résultat de la commande
     */
    public String executerCommande(int id) {
        CommandeFichier cmdFichier=commandeFichierMap.get(id);
        cmdFichier.setInvocateur(invocateur);
        cmdFichier.setFichier(fichier);

        try {
            cmdFichier.executer();
            return "Commande sur " + fichier.getName();
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

    private void fillCommandeFichierMap(Map<Integer,CommandeFichier> map) {
    }
}
