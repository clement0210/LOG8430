package comanche;

import comanche.model.CommandeDynamic;
import comanche.model.Invocateur;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by clement0210 on 14-03-13.
 */
public class CommandRequestHandler implements RequestHandler {

    private static final String COMMANDES = "commandes";
    private Map<String, CommandeDynamic> commandeFichier;

    public CommandRequestHandler(){
        commandeFichier=new HashMap<>();
    }

    // functional aspect
    @Override
    public void handleRequest(Request r) throws IOException {
        fillCommandeFichier();
    }

    /**
     * Méthode pour accèder à la table de commandes fichiers. Les clés sont les noms des fichiers/classes
     * @return la map de commandes de fichiers
     */
    public Map<String, CommandeDynamic> getCommandeFichier() {
        return commandeFichier;
    }
    /**
     *
     * @param nom un nom de fichier
     * @return le nom du fichier parsé
     */
    private String parseNomFichier(String nom) {
        String[] nomFichier = nom.split("\\.");
        return nomFichier[0];
    }

    /**
     * Methode permettant de lister les fichiers à chargés dynamiquement
     * @param directory un dossier
     * @return la liste de fichiers
     */
    private File[] getFichiersCommandes(File directory) {
        return directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        });
    }
    /**
     * Methode permettant de remplir la map. Le remplissage s'effectue grâce aux commandes qui doivent être chargé dynamiquement
     */
    public void fillCommandeFichier() {

        File directory = new File(COMMANDES);
        if(!directory.exists()){
            throw new RuntimeException("Not any directory"+directory.getAbsolutePath());
        }
        File[] files = getFichiersCommandes(directory);

        ClassLoader myClassLoader = ClassLoader.getSystemClassLoader();
        for (File file : files) {
            Class classeCommande = null;
            Object instanceCommande = null;
            String nomFichier=parseNomFichier(file.getName());
            // On ne charge pas 2 fois la même commande
            if(!commandeFichier.containsKey(nomFichier)){
                try {
                    classeCommande = myClassLoader.loadClass("comanche.model." + nomFichier);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                try {
                    instanceCommande = classeCommande.getDeclaredConstructor(Invocateur.class, File.class).newInstance(new Invocateur(), null);
                    commandeFichier.put(nomFichier, new CommandeDynamic(classeCommande, instanceCommande));
                    System.out.println("New command : " + nomFichier);
                } catch (InstantiationException | IllegalAccessException
                        | IllegalArgumentException | InvocationTargetException
                        | NoSuchMethodException | SecurityException e1) {
                    e1.printStackTrace();
                }
            }

        }

    }
}
