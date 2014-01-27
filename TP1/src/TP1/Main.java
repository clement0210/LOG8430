package TP1;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//import java.io.File;

@RunWith( JUnit4.class)
public class Main {

	@Test
	public static void main(String[] args) {
		/*Fichier fichier1=new Fichier("fichier 1");
		Fichier fichier2=new Fichier("fichier 1");
		Fichier fichier3=new Fichier("fichier 1");
		
		List<Fichier> ssFichiers1=new ArrayList<Fichier>();
		ssFichiers1.add(fichier1);
		ssFichiers1.add(fichier2);
		
		Fichier dossier2=new Fichier("Dossier 2",ssFichiers1);
		
		List<Fichier> ssFichiers2=new ArrayList<Fichier>();
		ssFichiers2.add(dossier2);
		ssFichiers2.add(fichier3);
		
		Fichier dossier1=new Fichier("Dossier 1",ssFichiers2);*/
		
		CommandeManager cmdManager=new CommandeManager();
		cmdManager.manage();
		
		new CommandeFrame().show();
	}

}
