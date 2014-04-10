package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith( Suite.class )
@SuiteClasses( { TestSuite1.class, TestSuite2.class, TestSuite3.class } )
public class TP1_TestSuite 
{
	@BeforeClass
	public static void setUpClass()
	{
		System.out.println( "TP1 - Suite de testes -> \"setUpClass\"" );
	}
	
	@AfterClass
	public static void tearDownClass()
	{
		System.out.println( "TP1 - Suite de testes -> \"tearDownClass\"" );
	}
}
