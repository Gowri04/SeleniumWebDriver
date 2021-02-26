package selenium.webdriver.webdrivercommands;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class WaitCommands 
{
	WebDriver d;
	@BeforeMethod
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		d=new ChromeDriver();
		
		d.manage().window().maximize();
	}
	@Test()
	public void implicitlyWait()
	{
		d.get("https://demoqa.com/text-box");
		
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		d.findElement(By.xpath("//*[@id=\"userName\"]"));
	
	}
	@Test()
	public void explicitlytWait()
	{
		d.get("https://demoqa.com/text-box");
		
		WebDriverWait w=new WebDriverWait(d,10);
		
		d.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("GowriS");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"userNam\"]")));
			
	}
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}