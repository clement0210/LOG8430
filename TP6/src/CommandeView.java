import javax.swing.*;

/**
 * Classe de structure permettant de visualiser une commande (boutton d'action et zone de résultat)
 */
public class CommandeView {

	private JButton commandeButton;
	private JLabel resultatCommande;

    /**
     *
     * @param commandeButton un bouton d'action de commande
     * @param resultatCommande un label de resultat
     */
	public CommandeView(JButton commandeButton, JLabel resultatCommande) {
		this.resultatCommande = resultatCommande;
		this.commandeButton = commandeButton;
	}

    /**
     *
     * @return la label de resultat
     */
	public JLabel getResultatCommande() {
		return resultatCommande;
	}

    /**
     *
     * @param resultatCommande un label de resultat
     */
	public void setResultatCommande(JLabel resultatCommande) {
		this.resultatCommande = resultatCommande;
	}

    /**
     *
     * @return le bouton d'action de la commmande
     */
	public JButton getCommandeButton() {
		return commandeButton;
	}

    /**
     *
     * @param commandeButton un bouton d'action de commande
     */
	public void setCommandeButton(JButton commandeButton) {
		this.commandeButton = commandeButton;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandeView other = (CommandeView) obj;
		if (commandeButton == null) {
			if (other.commandeButton != null)
				return false;
		} else if (!commandeButton.equals(other.commandeButton))
			return false;
		if (resultatCommande == null) {
			if (other.resultatCommande != null)
				return false;
		} else if (!resultatCommande.equals(other.resultatCommande))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commandeButton == null) ? 0 : commandeButton.hashCode());
		result = prime
				* result
				+ ((resultatCommande == null) ? 0 : resultatCommande.hashCode());
		return result;
	}
}
