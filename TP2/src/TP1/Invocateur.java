package TP1;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Classe d'entrée utilisateur
 */
public class Invocateur {

    /**
     * Methode de récupération du nom d'un fichier selectionné par l'utilisateur
     * @return le nom du fichier selectionné
     */
    public String getNomFichier(){
        JFileChooser chooser = new JFileChooser(new File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
}