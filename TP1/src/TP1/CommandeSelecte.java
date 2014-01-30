package TP1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandeSelecte extends CommandeFichier {
	
	public CommandeSelecte(Invocateur invocateur) {
		super(invocateur,null);
	}

	public void executer() {
		File fichier = new File(invocateur.getNomFichier());
		setFichier(fichier);
	}

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
