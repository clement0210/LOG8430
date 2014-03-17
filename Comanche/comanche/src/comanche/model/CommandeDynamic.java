package comanche.model;

/**
 * Structure de données d'une Commande chargée dynamiquement
 */
public class CommandeDynamic {

	private Class classeCommande;
	private Object instanceCommande;

    /**
     *
     * @param classeCommande un classe de commmande
     * @param instanceCommande une instance de commande
     */
	public CommandeDynamic(Class classeCommande, Object instanceCommande) {
		this.classeCommande = classeCommande;
		this.instanceCommande = instanceCommande;
	}

    /**
     *
     * @return la classe de la commande
     */
	public Class getClasseCommande() {
		return classeCommande;
	}

    /**
     *
     * @param classeCommande une classe de commmande
     */
	public void setClasseCommande(Class classeCommande) {
		this.classeCommande = classeCommande;
	}

    /**
     *
     * @return l'instance de la commande
     */
	public Object getInstanceCommande() {
		return instanceCommande;
	}

    /**
     *
     * @param instanceCommande une instance de commande
     */
	public void setInstanceCommande(Object instanceCommande) {
		this.instanceCommande = instanceCommande;
	}
}
