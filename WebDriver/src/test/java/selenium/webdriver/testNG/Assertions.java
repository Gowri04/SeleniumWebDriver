package selenium.webdriver.testNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
public class Assertions 
{
	WebDriver d;
	
	@BeforeMethod()
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
			
		d=new ChromeDriver();
	
		d.manage().window().maximize();
	}
	
	@Test()
	public void hardAssert() throws Exception
	{
		d.get("https://demoqa.com/");
		
		String expected="ToolsQA";
		String actual=d.getTitle();
		System.out.println(actual);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test()
	public void softdAssert() throws Exception
	{
		d.get("https://demoqa.com/");
		
		String expected="ToolsA";
		String actual=d.getTitle();
		System.out.println(actual);
		
		SoftAssert s=new SoftAssert();
		s.assertEquals(actual, expected);	
		//s.assertAll();
	}
	
	@AfterMethod
	public void tearDown()
	{
		d.close();
	}
}
/*

What is Assertion?

Asserts helps us to verify the conditions of the test and decide whether test has failed or passed. 

A test is considered successful ONLY if it is completed without throwing any exception.

Types of Assertions:

1) Hard Assertion
2) Soft Assertion

Hard Assertion
It is the default assert mechanism built into TestNG’s package. 

We use it when a test has to stop immediately after the assertion fails.

Soft Assertion

It is a custom assert mechanism supported by TestNG’s package. 

We use it when a test has to continue execution even after an assertion fails in the sequence.

Hard Assertions

1) Assert.assertTrue()
2) Assert.assertFalse()
3) Assert.assertEquals()

*/