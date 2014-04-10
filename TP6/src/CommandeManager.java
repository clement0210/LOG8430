import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe de controle du programme
 */
public class CommandeManager implements Observer{

	private static final String COMMANDES = "commandes";
	private Invocateur invocateur;
	private File fichier;
	private CommandeFrame commandeFrame;
	private Map<Integer, CommandeDynamic> commandeFichierMap;

	/**
	 * Constructeur par défaut
	 */
	public CommandeManager() {
		invocateur = new Invocateur();
		fichier = new File(".");
		commandeFichierMap = new HashMap<Integer, CommandeDynamic>();
		fillCommandeFichier(commandeFichierMap);
		commandeFrame = new CommandeFrame(this);

	}

    /**
     *
     * @return la map de commandes
     */
	public Map<Integer, CommandeDynamic> getCommandeFichierMap() {
		return commandeFichierMap;
	}

    /**
     *
     * @param commandeFichierMap une map de commandes
     */
	public void setCommandeFichierMap(
			Map<Integer, CommandeDynamic> commandeFichierMap) {
		this.commandeFichierMap = commandeFichierMap;
	}
	
	/**
	 * Méthode de manage de la vue
	 */
	public void manage() {
		commandeFrame.display();
	}

	/**
	 * Methode d'exécution de la commande
	 * 
	 * @return le résultat de la commande
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String executerCommande(int id) {
		CommandeDynamic commandeDynamic = commandeFichierMap.get(id);
		Method methodExecuter = null;
		Method methodeSetInvocateur = null;
		Method methodeSetFichier = null;
		Class classeCommande = commandeDynamic.getClasseCommande();
		Object instanceCommande = commandeDynamic.getInstanceCommande();
		
		try {
			methodExecuter = classeCommande.getMethod("executer");
			methodeSetInvocateur = classeCommande.getMethod("setInvocateur", new Class[] { Invocateur.class });
			methodeSetFichier = classeCommande.getMethod("setFichier", new Class[] { File.class });
		} catch (NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
		}

		try {
			methodeSetInvocateur.invoke(instanceCommande, invocateur);
			methodeSetFichier.invoke(instanceCommande, fichier);
			methodExecuter.invoke(instanceCommande);
			return "Commande sur " + fichier.getName();
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			return "Impossible d'appliquer la commande (voir le log)";
		}
	}

	/**
	 * Methode d'exécution du selecteur de fichier
	 * 
	 * @return le résultat du selecteur de fichier
	 */
	public String executerSelect() {
		CommandeSelect commandeSelecte = new CommandeSelect(invocateur);
		commandeSelecte.executer();
		fichier = commandeSelecte.getFichier();
		StringBuilder str = new StringBuilder();
		str.append("<html>" + fichier.getName() + "<br/>");
		for (File file : commandeSelecte.getContenu()) {
			str.append("&nbsp;&nbsp;&nbsp;&nbsp;" + file.getName() + "<br/>");
		}
		str.append("</html>");
		return str.toString();
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
     * Methode permettant de remplir la map passée en paramètre. Le remplissage s'effectue grâce aux commandes qui doivent être chargé dynamiquement
     * @param commandeFichier un map d'identifiant et de commande dynamique
     */
	private void fillCommandeFichier(Map<Integer, CommandeDynamic> commandeFichier) {
        commandeFichier.clear();
		File directory = new File(COMMANDES);
		File[] files = getFichiersCommandes(directory);

		ClassLoader myClassLoader = ClassLoader.getSystemClassLoader();
		int compteur = 0;
		for (File file : files) {
			compteur++;
			Class classeCommande = null;
			Object instanceCommande = null;
			
			try {
				classeCommande = myClassLoader.loadClass("TP2." + parseNomFichier(file.getName()));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try {
				instanceCommande = classeCommande.getDeclaredConstructor(Invocateur.class, File.class).newInstance(invocateur, fichier);
				commandeFichier.put(compteur, new CommandeDynamic(classeCommande, instanceCommande));
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
		}

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

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof CommandeFrame){
            System.out.println("Udpdating command");
            CommandeFrame cmdFrame= (CommandeFrame) o;
            fillCommandeFichier(commandeFichierMap);
            cmdFrame.setCommandeManager(this);
            cmdFrame.repackCommandViewGrid();
            cmdFrame.repaint();

        }
    }
}
