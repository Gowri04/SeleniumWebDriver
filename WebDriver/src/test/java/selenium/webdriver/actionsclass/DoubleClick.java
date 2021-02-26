package selenium.webdriver.actionsclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
public class DoubleClick 
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
	public void doubleClick() throws Exception
	{
		d.get("https://demoqa.com/buttons");
		
		Actions a=new Actions(d);
		
		WebElement doubleclick=d.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/button"));
	
		a.doubleClick(doubleclick).build().perform();
		
		Thread.sleep(2000);
	}
	
	@Test
	public void doubleClick1() throws InterruptedException
	{
		d.get("http://api.jquery.com/dblclick/");

		Actions act = new Actions(d);

		d.switchTo().frame(0);

		WebElement ele = d.findElement(By.xpath("/html/body/div"));

		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
		// ele);// scroll down for the element

		String color = ele.getCssValue("color").toString();
		System.out.println("color before double click:" + color); // blue

		Thread.sleep(5000);
		act.doubleClick(ele).build().perform();

		Thread.sleep(2000);
	  	color = ele.getCssValue("color").toString();
	  	System.out.println("color after double click:" + color); // yellow
		
	  	Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();	
	}
}