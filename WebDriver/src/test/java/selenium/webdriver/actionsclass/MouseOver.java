package selenium.webdriver.actionsclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
public class MouseOver 
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
	public void mouseOver() throws InterruptedException 
	{

		d.get("https://opensource-demo.orangehrmlive.com/");

		d.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");

		d.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123"); 

		d.findElement(By.cssSelector("input[type='submit']")).click(); 
		
		Actions act=new Actions(d);
		
		WebElement admin=d.findElement(By.linkText("Admin"));
	
		WebElement usermanagement=d.findElement(By.xpath("//*[@id=\"menu_admin_UserManagement\"]"));

		WebElement users=d.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]"));
		
		act.moveToElement(admin).build().perform();
		Thread.sleep(2000);
		
		act.moveToElement(usermanagement).build().perform();
		Thread.sleep(2000);
		
		act.moveToElement(users).click().build().perform();
		
		//act.moveToElement(admin).moveToElement(usermanagement).moveToElement(users).click().build()act.perform();		
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}


