package selenium.webdriver.actionsclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class Slider 
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
	public void slider() 
	{
		d.get("https://jqueryui.com/slider/");
        
		d.manage().window().maximize();
		        
		d.switchTo().frame(0);
		        
		WebElement slideElement = d.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));

		Actions actionsSlide = new Actions(d);
		        
		actionsSlide.dragAndDropBy(slideElement, 100, 0).perform();
		        
		System.out.println("Done Sliding");
		
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}
