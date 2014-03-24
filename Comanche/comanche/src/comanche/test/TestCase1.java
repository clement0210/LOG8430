/**
 * 
 */
package comanche.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestCase1{

	// To be tested you need to choose a file/folder and manually get its size in oracleFileSize
	private File file = new File( "C:\\" );
	private int oracleFileSize = 382; // For testing purposes
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {}

	@Test
	public void test() 
	{
		System.out.println( "\ttest()" );
		org.junit.Assert.assertTrue( "Test non-réussi, cause externe!", oracleFileSize == file.length() );
	}

}
