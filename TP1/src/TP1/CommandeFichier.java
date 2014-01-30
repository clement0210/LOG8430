package TP1;

import java.io.File;


public abstract class CommandeFichier implements Commande {
	
	
	protected TypeFichier typeFichier; 
	protected Invocateur invocateur;
	protected File fichier;


	
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

    protected boolean isExecutable(){
        if(fichier==null){
            return false;
        }
        if( (typeFichier==TypeFichier.DOSSIER || typeFichier==TypeFichier.FICHIERETDOSSIER) && fichier.isDirectory()){
            return true;
        }
        else if( (typeFichier==TypeFichier.FICHIER || typeFichier==TypeFichier.FICHIERETDOSSIER) && !fichier.isDirectory()){
            return true;
        }
        return false;
    }

	public abstract void executer() throws CommandeException;

}