package TP1;

import java.io.File;

public class CommandeManager {
	
	private Invocateur invocateur;
	private File fichier;
	
	public CommandeManager(){
		invocateur = new Invocateur();
		fichier = new File(".");
	}
	
	public void manage(){
		
		//CommandeVide1 cmd1=new CommandeVide1(invocateur,new File("/home/clement0210/Documents/LOG8430/LOG8430/resources"));
		CommandeFrame commandeFrame = new CommandeFrame(this);
		
		
		commandeFrame.display();
//		cmd1.executer();
	}
	
	public String executerCommande1(){
		CommandeVide1 commandeVide1 = new CommandeVide1( invocateur,fichier);
		commandeVide1.executer();
		return "Commande 1 sur"+fichier.getName();
	}

	public String executerCommande2(){
		return "";
	}
	public String executerCommande3(){
		return "";
	}
	public String executerSelect(){
		CommandeSelecte commandeSelecte = new CommandeSelecte(invocateur);
		commandeSelecte.executer();
		fichier=commandeSelecte.getFichier();
		return commandeSelecte.getFichier().getName();
	}
}
