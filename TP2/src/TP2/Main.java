package TP2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

//import java.io.File;

@RunWith(JUnit4.class)
public class Main {

	@Test
	public static void main(String[] args) {

        File file=new File(".");
        System.out.print(file.getAbsolutePath());
		CommandeManager cmdManager = new CommandeManager();
		cmdManager.manage();

	}

}
