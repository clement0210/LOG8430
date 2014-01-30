package TP1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CommandeFrame extends JFrame implements ActionListener{
	
	CommandeManager commandeManager;
	
	
	private JButton select,commande1,commande2,commande3;
	private JLabel resultatCommande1,resultatCommande2,resultatCommande3, afficherContenu;
	
	public CommandeFrame(CommandeManager commandeManager){
		select=new JButton("Select a file or folder");
		select.setActionCommand("select");
		select.addActionListener(this);
		commande1=new JButton("Commande 1");
		commande1.setActionCommand("cmd1");
		commande1.addActionListener(this);
		commande2=new JButton("Commande 2");
		commande2.setActionCommand("cmd2");
		commande2.addActionListener(this);
		commande3=new JButton("Commande 3");
		commande3.setActionCommand("cmd3");
		commande3.addActionListener(this);
		resultatCommande1=new JLabel("Results of command 1");
		resultatCommande2=new JLabel("Results of command 2");
		resultatCommande3=new JLabel("Results of command 3");
		afficherContenu=new JLabel("List showing the content ...");
		
		GridLayout grid=new GridLayout(3,2);
		JPanel gridPanel=new JPanel(grid);
		gridPanel.add(commande1);
		gridPanel.add(resultatCommande1);
		gridPanel.add(commande2);
		gridPanel.add(resultatCommande2);
		gridPanel.add(commande3);
		gridPanel.add(resultatCommande3);
		
		GridLayout grid2=new GridLayout(2,1);
		JPanel gridPanel2=new JPanel(grid);
		gridPanel2.add(afficherContenu);
		gridPanel2.add(select);
		
		JPanel mainPanel=new JPanel();
		mainPanel.add(gridPanel2);
		mainPanel.add(gridPanel);
		this.setSize(700, 700);
		this.add(mainPanel);
		this.commandeManager = commandeManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("avant select");
		String action=e.getActionCommand();
		if(action.equals("cmd1")){
			String resultat=commandeManager.executerCommande1();
			resultatCommande1.setText(resultat);
		}
		else if(action.equals("cmd2")){
			String resultat=commandeManager.executerCommande2();
			resultatCommande2.setText(resultat);
		}
		else if(action.equals("cmd3")){
			String resultat=commandeManager.executerCommande3();
			resultatCommande3.setText(resultat);
		}
		else if(action.equals("select")){
			System.out.println("select1");
			String resultat=commandeManager.executerSelect();
			System.out.println("select2");
			afficherContenu.setText(resultat);
		}
		
	}
	
	public CommandeManager getCommandeManager() {
		return commandeManager;
	}

	public void setCommandeManager(CommandeManager commandeManager) {
		this.commandeManager = commandeManager;
	}
	
	public void display(){
		this.setVisible(true);
	}
	public void close(){
		this.dispose();
	}

}
