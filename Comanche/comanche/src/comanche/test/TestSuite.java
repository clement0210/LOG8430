package comanche.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith( Suite.class )
@SuiteClasses( { TestGroup1.class } )
public class TestSuite 
{
	@BeforeClass
	public static void setUpClass()
	{
		System.out.println( "Suite de testes -> \"setUpClass\"" );
	}
	
	@AfterClass
	public static void tearDownClass()
	{
		System.out.println( "Suite de testes -> \"tearDownClass\"" );
	}
}
