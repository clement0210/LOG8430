package comanche.model;

import java.io.File;

/**
 * Classe abstraite representant la commande sur un fichier
 */
public abstract class CommandeFichier {
	
	
	protected TypeFichier typeFichier; 
	protected Invocateur invocateur;
	protected File fichier;
    protected String resultat;


    /**
     * Constrcuteur de CommandeFichier
     * @param invocateur un invocateur
     * @param fichier un fichier
     */
	public CommandeFichier(Invocateur invocateur, File fichier){
		this.invocateur=invocateur;
		this.fichier=fichier;
	}

    /**
     *
     * @return l'invocateur
     */
	public Invocateur getInvocateur() {
		return invocateur;
	}

    /**
     *
     * @param invocateur un invocateur
     */
	public void setInvocateur(Invocateur invocateur) {
		this.invocateur = invocateur;
	}

    /**
     *
     * @return le fichier
     */
	public File getFichier() {
		return fichier;
	}

    /**
     *
     * @param fichier le fichier
     */
	public void setFichier(File fichier) {
		this.fichier = fichier;
	}

    /**
     *
     * @return le type de fichier
     */
	public TypeFichier getTypeFichier() {
		return typeFichier;
	}

    /**
     *
     * @param typeFichier le type de fichier
     */
	public void setTypeFichier(TypeFichier typeFichier) {
		this.typeFichier = typeFichier;
	}

    /**
     *
     * @return si la commande sur le fichier est exécutable
     */
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

    /**
     * Methode d'execution de la commande
     * @throws CommandeException Problème lors de l'exécution
     */
	public abstract void executer() throws CommandeException;

    /**
     * Methode d'accession au résultat d'une commande
     * @return les resultat de l'exécution d'une commande
     */
    public String getResultat() {
        return resultat;
    }
}