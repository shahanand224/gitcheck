package KairavAcademy.SeleniumJava;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestClass1 {
	
	ExtentReports extent;
	
	@BeforeMethod
	public void extentReport()
	{
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		
	}
	@Parameters({"param"})
	@Test
	public void testcase1(String val1)
	{
		extent.createTest("testcase1");
		System.out.println("This is testcase1:"+val1);
		extent.flush();
		
	}
	
	@Test(groups= {"Smoke"})
	public void testCase2()
	{
		System.out.println("This is testcase2");
	}
	
	@Test(alwaysRun=true,dataProvider="dataMaster")
	public void testcase3(HashMap<String,String> map)
	{
		System.out.println("This is testcase3");
		System.out.println("DataProvider set is:"+map.get("Param1")+"&"+map.get("Param2"));
	}
	
	@Test(enabled=false)
	public void testcase4()
	{
		System.out.println("This is testcase4");
	}
	
	@DataProvider
	public Object[][] dataMaster()
	{
		HashMap<String,String> map =  new HashMap<String,String>();
		map.put("Param1", "Set1Val1");
		map.put("Param2", "Set1Val2");
		
		HashMap<String,String> map1 =  new HashMap<String,String>();
		map1.put("Param1", "Set2Val1");
		map1.put("Param2", "Set2Val2");
		
		HashMap<String,String> map2 =  new HashMap<String,String>();
		map2.put("Param1", "Set2Val1");
		map2.put("Param2", "Set2Val2");
		

		
		return new Object[][] {{map},{map1},{map1}};
	}
}
