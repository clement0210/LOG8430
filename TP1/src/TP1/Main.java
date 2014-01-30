package TP1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//import java.io.File;

@RunWith( JUnit4.class)
public class Main {

	@Test
	public static void main(String[] args) {

		CommandeManager cmdManager=new CommandeManager();
		cmdManager.manage();
	}

}
