package selenium.webdriver.webelements;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class CheckBox 
{
	WebDriver d;
	
	@BeforeMethod
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		d=new ChromeDriver();
		
		d.manage().window().maximize();
		
		d.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@Test
	public void checkBox() 
	{
		d.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		
		WebElement checkbox=d.findElement(By.xpath("//*[@id=\"isAgeSelected\"]"));
	
		WebElement message=d.findElement(By.xpath("//div[@id='txtAge']"));
	
		for(int i=0;i<=2;i++)
		{
			checkbox.click();
			System.out.println(checkbox.isSelected());
			System.out.println(message.getText());
		}
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}
