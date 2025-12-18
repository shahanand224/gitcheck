package KairavAcademy.SeleniumJava;

import org.testng.annotations.Test;

public class TestClass2 {
	
	@Test(dependsOnMethods= {"testCase6"})
	public void testCase5()
	{
		System.out.println("This is testcase5");
	}
	
	@Test
	public void testCase6()
	{
		System.out.println("This is testcase6");
	}

}
