package TP2;

import javax.swing.*;

/**
 * Created by clement0210 on 14-02-06.
 */
public class CommandeView {

	private JButton commandeButton;
	private JLabel resultatCommande;

	public CommandeView(JButton commandeButton, JLabel resultatCommande) {
		this.resultatCommande = resultatCommande;
		this.commandeButton = commandeButton;
	}

	public JLabel getResultatCommande() {
		return resultatCommande;
	}

	public void setResultatCommande(JLabel resultatCommande) {
		this.resultatCommande = resultatCommande;
	}

	public JButton getCommandeButton() {
		return commandeButton;
	}

	public void setCommandeButton(JButton commandeButton) {
		this.commandeButton = commandeButton;
	}

	@Override
	public boolean equals(java.lang.Object obj) {
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
