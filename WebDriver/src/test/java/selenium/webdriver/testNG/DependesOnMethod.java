package selenium.webdriver.testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class DependesOnMethod 
{
	WebDriver d;
	
	@Test()
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
			
		d=new ChromeDriver();
	
		d.manage().window().maximize();
	}
	
	@Test(dependsOnMethods="setup")
	public void rightClick() throws Exception
	{
		d.get("https://demoqa.com/buttons");
		
		Actions a=new Actions(d);
		
		WebElement rightclick=d.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
	
		a.contextClick(rightclick).build().perform();
		
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods="rightClick")
	public void tearDown()
	{
		d.close();
	}
}
