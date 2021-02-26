package selenium.webdriver.actionsclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
public class ToolTip 
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
	public void toolTip()
	{
		d.get("https://demoqa.com/tool-tips");
		
		Actions a=new Actions(d);
		
		WebElement tooltip=d.findElement(By.xpath("//*[@id=\"toolTipButton\"]"));
		
		System.out.println(tooltip.getText());
	
	}	
	
	@Test
	public void toolTip1()
	{
		d.get("https://demoqa.com/tool-tips");
		
		Actions a=new Actions(d);
		
		WebElement tooltip=d.findElement(By.xpath("//*[@id=\"toolTipTextField\"]"));
		
		System.out.println(tooltip.getAttribute("placeholder"));
	}
	
	@Test
	public void toolTip2()
	{	
		d.get("https://demoqa.com/tool-tips");
		
		Actions a=new Actions(d);
		
		WebElement tooltip=d.findElement(By.xpath("//*[@id=\"texToolTopContainer\"]/a[1]"));
		
		System.out.println(tooltip.getText());
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}
/*

How to capture tooltip in Selenium?
We can capture tooltip 
	1. using getAttribute() and 
	2. Using move to element() from action class and using getText().


*/