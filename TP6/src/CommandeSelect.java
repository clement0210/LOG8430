import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe representant la commande de selecteur de fichier
 */
public class CommandeSelect extends CommandeFichier {

    /**
     * Constrcuteur de CommandeSelecte
     * @param invocateur un invocateur
     */
	public CommandeSelect(Invocateur invocateur) {
		super(invocateur,null);
	}

    /**
     * Methode d'execution de la commande
     */
	public void executer() {
		File fichier = new File(invocateur.getNomFichier());
		setFichier(fichier);
	}

    /**
     *
     * @return la liste des fichiers/dossiers du dossier (vide si fichier)
     */
    public List<File> getContenu(){
        List<File> files=new ArrayList<File>();
        if(fichier != null){
            if(fichier.isDirectory()){
                files.addAll(Arrays.asList(fichier.listFiles()));
            }
        }
        return files;
    }

}
