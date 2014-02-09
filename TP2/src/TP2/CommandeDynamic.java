package TP2;

public class CommandeDynamic {

	private Class classeCommande;
	private Object instanceCommande;

	public CommandeDynamic(Class classeCommande, Object instanceCommande) {
		this.classeCommande = classeCommande;
		this.instanceCommande = instanceCommande;
	}

	public Class getClasseCommande() {
		return classeCommande;
	}

	public void setClasseCommande(Class classeCommande) {
		this.classeCommande = classeCommande;
	}

	public Object getInstanceCommande() {
		return instanceCommande;
	}

	public void setInstanceCommande(Object instanceCommande) {
		this.instanceCommande = instanceCommande;
	}
}
