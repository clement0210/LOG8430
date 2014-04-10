package TP2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe d'IHM du projet permettant l'affichage de l'interface d'actions des commandes
 */
public class CommandeFrame extends Observable implements ActionListener {

	private CommandeManager commandeManager;
    private JFrame frame;
    private JPanel mainPanel;
	private JButton select;
	private JLabel afficherContenu;
    private  JPanel gridPanel;
	private Map<Integer, CommandeView> commandeViewMap;

    /**
     *
     * @param commandeManager un manager de commande
     */
	public CommandeFrame(CommandeManager commandeManager) {
        this.commandeManager = commandeManager;
        this.addObserver(commandeManager);
        frame=new JFrame();
        frame.setSize(1000, 1000);
        mainPanel= new JPanel();
        afficherContenu = new JLabel("List showing the content ...");
        select=new JButton("Select a file or a directory");
        select.setActionCommand("select");
        select.addActionListener(this);
        GridLayout grid2 = new GridLayout(2, 1);
        JPanel gridPanel2 = new JPanel(grid2);
        gridPanel2.add(afficherContenu);
        gridPanel2.add(select);


        mainPanel = new JPanel();
        mainPanel.add(gridPanel2);

        GridLayout grid = new GridLayout(3, 2);
        gridPanel = new JPanel(grid);
        mainPanel.add(gridPanel);

        frame.add(mainPanel);

		repackCommandViewGrid();
        frame.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("select")) {
			String resultat = commandeManager.executerSelect();
			afficherContenu.setText(resultat);

		} else {
			try {
				int id = Integer.parseInt(action);
				String resultat = commandeManager.executerCommande(id);
                System.out.println(resultat);
                setChanged();
                notifyObservers();
				commandeViewMap.get(id).getResultatCommande().setText(resultat);

			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}

	}

    /**
     *
     * @return le manager de commande
     */
	public CommandeManager getCommandeManager() {
		return commandeManager;
	}

    /**
     *
     * @param commandeManager un manager de commande
     */
	public void setCommandeManager(CommandeManager commandeManager) {
		this.commandeManager = commandeManager;
	}

    /**
     * Méthode pour afficher la fenètre
     */
	public void display() {
		frame.setVisible(true);
	}

    /**
     * Methode pour fermer la fenètre
     */
	public void close() {
		frame.dispose();
	}

    /**
     * Methode pour mettre à jour la fenètre d'affichage
     */
    public void repackCommandViewGrid(){

        gridPanel.removeAll();

        commandeViewMap = new HashMap<Integer, CommandeView>();


        fillCommandViews();



        for (int key : commandeViewMap.keySet()) {
            CommandeView commandeView = commandeViewMap.get(key);
            gridPanel.add(commandeView.getCommandeButton());
            gridPanel.add(commandeView.getResultatCommande());
        }


    }

    /**
     * Méthode pour remplir la map de CommandView
     */
    private void fillCommandViews(){
        commandeViewMap.clear();
        for (int key : commandeManager.getCommandeFichierMap().keySet()) {
            CommandeDynamic commandeDynamic=commandeManager.getCommandeFichierMap().get(key);
            JButton button = new JButton(commandeDynamic.getClasseCommande().getName());
            button.setActionCommand(Integer.toString(key));
            button.addActionListener(this);
            commandeViewMap.put(key, new CommandeView(button, new JLabel(
                    "Resultat commande " + key)));
        }

    }

    /**
     * Methode pour redessiner la fenètre d'affichage
     */
    public void repaint(){
        frame.revalidate();
        frame.repaint();
    }

}
