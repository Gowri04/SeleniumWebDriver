package selenium.webdriver.actionsclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
public class RightClick 
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
	public void rightClick() 
	{
		d.get("https://api.jquery.com/contextmenu/");
		
		Actions a=new Actions(d);		
		
		a.contextClick();
	}
	
	@Test
	public void rightClick1() throws Exception
	{
		d.get("https://demoqa.com/buttons");
		
		Actions a=new Actions(d);
		
		WebElement rightclick=d.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
	
		a.contextClick(rightclick).build().perform();
		
		Thread.sleep(2000);
	}
	
	@Test
	public void rightClick2() throws Exception
	{
		d.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		  
		Actions act = new Actions(d);

		WebElement button = d.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));

		act.contextClick(button).build().perform(); 

		d.findElement(By.xpath("/html/body/ul/li[3]/span")).click(); 

		System.out.println(d.switchTo().alert().getText());

		d.switchTo().alert().accept();
	}

	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}
