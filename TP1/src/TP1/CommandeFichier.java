package TP1;

import java.io.File;


public abstract class CommandeFichier implements Commande {
	
	
	protected TypeFichier typeFichier; 
	private Invocateur invocateur;
	private File fichier;


	
	public CommandeFichier(Invocateur invocateur, File fichier){
		this.invocateur=invocateur;
		this.fichier=fichier;
	}

	public Invocateur getInvocateur() {
		return invocateur;
	}

	public void setInvocateur(Invocateur invocateur) {
		this.invocateur = invocateur;
	}
	public File getFichier() {
		return fichier;
	}

	public void setFichier(File fichier) {
		this.fichier = fichier;
	}
	
	public TypeFichier getTypeFichier() {
		return typeFichier;
	}

	public void setTypeFichier(TypeFichier typeFichier) {
		this.typeFichier = typeFichier;
	}



	public abstract void executer();

}