package selenium.webdriver.webelements;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class WebButton 
{
	WebDriver d;
	
	@BeforeMethod
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		d=new ChromeDriver();
		
		d.manage().window().maximize();
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void webbutton() 
	{

		d.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

		d.findElement(By.xpath("//*[@id=\"user-message\"]")).sendKeys("Gowri");
		
		d.findElement(By.xpath("//button[@onclick='showInput();']")).click();
		
		WebElement displayMessage=d.findElement(By.xpath("//*[@id=\"display\"]"));
		
		System.out.println(displayMessage.getText());	
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}
