package selenium.webdriver.testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
public class GroupingMethods 
{
	public WebDriver d;

	@BeforeMethod()
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
			
		d=new ChromeDriver();
	
		d.manage().window().maximize();
	}
	
	@Test(groups= {"Functional"})
	public void rightClick() throws Exception
	{
		d.get("https://demoqa.com/buttons");
		
		Actions a=new Actions(d);
		
		WebElement rightclick=d.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
	
		a.contextClick(rightclick).build().perform();
		
		Thread.sleep(2000);
	}
	@Test(groups= {"Functional"})
	public void doubleClick() throws Exception
	{
		d.get("https://demoqa.com/buttons");
		
		Actions a=new Actions(d);
		
		WebElement doubleclick=d.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/button"));
	
		a.doubleClick(doubleclick).build().perform();
		
		Thread.sleep(2000);
	}
	@Test
	public void toolTip()
	{	
		d.get("https://demoqa.com/tool-tips");
		
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
