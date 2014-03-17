package comanche.model;

import java.io.File;

/**
 * Created by clement0210 on 14-03-13.
 */
public class CommandeFichierTaille extends CommandeFichier{

    /**
     * Constrcuteur de CommandeFichier
     *
     * @param invocateur un invocateur
     * @param fichier    un fichier
     */
    public CommandeFichierTaille(Invocateur invocateur, File fichier) {
        super(invocateur, fichier);
        setTypeFichier(TypeFichier.FICHIERETDOSSIER);
    }

    @Override
    public void executer() throws CommandeException {
        resultat=Long.toString(fichier.length())+" o";
    }

}
