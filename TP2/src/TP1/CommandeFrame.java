package TP1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CommandeFrame extends JFrame implements ActionListener{
	
	CommandeManager commandeManager;
	
	
	private JButton select;
	private JLabel afficherContenu;
    private List<CommandeView> commandeViewList;

	
	public CommandeFrame(CommandeManager commandeManager){
        commandeViewList=new ArrayList<CommandeView>();
		select=new JButton("Select a file or folder");
		select.setActionCommand("select");
		select.addActionListener(this);
	    JButton commande1=new JButton("Commande 1");
		commande1.setActionCommand("cmd1");
		commande1.addActionListener(this);
		JButton commande2=new JButton("Commande 2");
		commande2.setActionCommand("cmd2");
		commande2.addActionListener(this);
		JButton commande3=new JButton("Commande 3");
		commande3.setActionCommand("cmd3");
		commande3.addActionListener(this);
		JLabel resultatCommande1=new JLabel("Results of command 1");
		JLabel resultatCommande2=new JLabel("Results of command 2");
		JLabel resultatCommande3=new JLabel("Results of command 3");

        commandeViewList.add(new CommandeView(commande1,resultatCommande1));
        commandeViewList.add(new CommandeView(commande2,resultatCommande2));
        commandeViewList.add(new CommandeView(commande3,resultatCommande3));


		afficherContenu=new JLabel("List showing the content ...");
		
		GridLayout grid=new GridLayout(3,2);
		JPanel gridPanel=new JPanel(grid);
        for(CommandeView commandeView:commandeViewList){
            gridPanel.add(commandeView.getCommandeButton());
            gridPanel.add(commandeView.getResultatCommande());
        }
		
		GridLayout grid2=new GridLayout(2,1);
		JPanel gridPanel2=new JPanel(grid2);
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
			//resultatCommande1.setText(resultat);
		}
		else if(action.equals("cmd2")){
			String resultat=commandeManager.executerCommande2();
			//resultatCommande2.setText(resultat);
		}
		else if(action.equals("cmd3")){
			String resultat=commandeManager.executerCommande3();
			//resultatCommande3.setText(resultat);
		}
		else if(action.equals("select")){
			String resultat=commandeManager.executerSelect();
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
