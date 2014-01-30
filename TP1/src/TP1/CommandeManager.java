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
	}
	
	public String executerCommande1() {
		CommandeVide1 commandeVide1 = new CommandeVide1(invocateur, fichier);
		commandeVide1.executer();
		return "Commande 1 sur " + fichier.getName();
	}

	public String executerCommande2(){
		CommandeVide2 commandeVide2 = new CommandeVide2(invocateur, fichier);
		commandeVide2.executer();
		return "Commande 2 sur " + fichier.getName();
	}
	
	public String executerCommande3(){
		CommandeVide3 commandeVide3 = new CommandeVide3(invocateur, fichier);
		commandeVide3.executer();
		return "Commande 3 sur " + fichier.getName();
	}
	
	public String executerSelect(){
		CommandeSelecte commandeSelecte = new CommandeSelecte(invocateur);
		commandeSelecte.executer();
		fichier = commandeSelecte.getFichier();
		return commandeSelecte.getFichier().getName();
	}
}
