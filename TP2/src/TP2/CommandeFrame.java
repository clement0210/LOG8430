package TP2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CommandeFrame extends JFrame implements ActionListener {

	private CommandeManager commandeManager;
	private JButton select;
	private JLabel afficherContenu;
	private Map<Integer, CommandeView> commandeViewMap;

	public CommandeFrame(CommandeManager commandeManager) {
		commandeViewMap = new HashMap<Integer, CommandeView>();
		select = new JButton("Select a file or folder");
		select.setActionCommand("select");
		select.addActionListener(this);
		for (int key : commandeManager.getCommandeFichierMap().keySet()) {
			JButton button = new JButton("Commande " + key);
			button.setActionCommand(Integer.toString(key));
			button.addActionListener(this);
			commandeViewMap.put(key, new CommandeView(button, new JLabel(
					"Resultat commande " + key)));
		}

		afficherContenu = new JLabel("List showing the content ...");

		GridLayout grid = new GridLayout(3, 2);
		JPanel gridPanel = new JPanel(grid);
		for (int key : commandeViewMap.keySet()) {
			CommandeView commandeView = commandeViewMap.get(key);
			gridPanel.add(commandeView.getCommandeButton());
			gridPanel.add(commandeView.getResultatCommande());
		}

		GridLayout grid2 = new GridLayout(2, 1);
		JPanel gridPanel2 = new JPanel(grid2);
		gridPanel2.add(afficherContenu);
		gridPanel2.add(select);

		JPanel mainPanel = new JPanel();
		mainPanel.add(gridPanel2);
		mainPanel.add(gridPanel);
		this.setSize(700, 700);
		this.add(mainPanel);
		this.commandeManager = commandeManager;
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
				commandeViewMap.get(id).getResultatCommande().setText(resultat);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}

	}

	public CommandeManager getCommandeManager() {
		return commandeManager;
	}

	public void setCommandeManager(CommandeManager commandeManager) {
		this.commandeManager = commandeManager;
	}

	public void display() {
		this.setVisible(true);
	}

	public void close() {
		this.dispose();
	}

}
