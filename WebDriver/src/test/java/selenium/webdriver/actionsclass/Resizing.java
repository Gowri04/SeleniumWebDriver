package selenium.webdriver.actionsclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
public class Resizing 
{
	WebDriver d;
	
	@BeforeMethod
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		d=new ChromeDriver();
		
		d.manage().window().maximize();
	}
	
	@Test
	public void reSizing() 
	{
		 d.get("https://jqueryui.com/resizable/");
	            
	     d.switchTo().frame(0);
	        
	     WebElement resizeElement = d.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));

	     Actions actionsResize = new Actions(d);
	        
	     //provide the x and y offset values
	     actionsResize.dragAndDropBy(resizeElement, 100, 25).perform();
	        
	     System.out.println("Done Resizing");
		
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}
