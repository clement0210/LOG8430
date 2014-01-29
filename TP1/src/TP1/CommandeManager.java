package TP1;

import java.io.File;

public class CommandeManager {
	
	public void manage(){
		Invocateur invocateur = new Invocateur();
		//CommandeVide1 cmd1=new CommandeVide1(invocateur,new File("/home/clement0210/Documents/LOG8430/LOG8430/resources"));
		CommandeVide1 cmd1 = new CommandeVide1( invocateur, new File( "C:\\workspace" ) );

		
		cmd1.executer();
	}
	
	public String executerCommande1(){
		return "";
	}

	public String executerCommande2(){
		return "";
	}
	public String executerCommande3(){
		return "";
	}
	public String executerSelect(){
		return "";
	}
}
