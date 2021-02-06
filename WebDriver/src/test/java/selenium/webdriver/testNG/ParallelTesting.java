package selenium.webdriver.testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ParallelTesting 
{
	public WebDriver d;
	
	@BeforeMethod()
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
			
		d=new ChromeDriver();
	
		d.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void rightClick() throws Exception
	{
		d.get("https://demoqa.com/buttons");
		
		Thread.sleep(2000);
		
		Actions a=new Actions(d);
		
		WebElement rightclick=d.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
	
		a.contextClick(rightclick).build().perform();
		
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void toolTip() throws Exception
	{	
		d.get("https://demoqa.com/tool-tips");
		
		Thread.sleep(2000);
		
		Actions a=new Actions(d);
		
		WebElement tooltip=d.findElement(By.xpath("//*[@id=\"toolTipButton\"]"));
		
		System.out.println(tooltip.getText());	
	}	
	
	@AfterMethod
	public void tearDown()
	{
		d.close();
	}
}	
