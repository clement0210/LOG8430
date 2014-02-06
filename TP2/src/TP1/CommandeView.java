package TP1;

import javax.swing.*;

/**
 * Created by clement0210 on 14-02-06.
 */
public class CommandeView {

    private JButton commandeButton;
    private JLabel resultatCommande;


    public CommandeView( JButton commandeButton,JLabel resultatCommande) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommandeView that = (CommandeView) o;

        if (commandeButton != null ? !commandeButton.equals(that.commandeButton) : that.commandeButton != null)
            return false;
        if (resultatCommande != null ? !resultatCommande.equals(that.resultatCommande) : that.resultatCommande != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resultatCommande != null ? resultatCommande.hashCode() : 0;
        result = 31 * result + (commandeButton != null ? commandeButton.hashCode() : 0);
        return result;
    }
}
