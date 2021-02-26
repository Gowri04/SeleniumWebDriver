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