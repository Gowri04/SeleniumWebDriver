package selenium.webdriver.webelements;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
public class Alerts 
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
	public void alertBox() 
	{
		d.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		d.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		
		Alert a=d.switchTo().alert();
		
		System.out.println(a.getText());
				
		a.accept();
	}
	
	@Test
	public void confirmBox() 
	{
		d.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		d.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		
		Alert a=d.switchTo().alert();
		
		System.out.println(a.getText());			
		
		a.accept();
		
		//a.dismiss();
	}
	@Test
	public void promptBox() throws InterruptedException 
	{
		d.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		d.findElement(By.xpath("//button[@onClick='myPromptFunction()']")).click();
	
		Alert a=d.switchTo().alert();
		
		d.switchTo().alert().sendKeys("Gowri");
		
		System.out.println(a.getText());
		
		a.accept();
	}
	
	@Test
	public void simpleAlert() 
	{
		d.get("https://demoqa.com/alerts");
			
		d.findElement(By.xpath("//*[@id=\"alertButton\"]")).click();

		Alert a=d.switchTo().alert();
					
		System.out.println(a.getText());
			
		a.accept();
	}

	@Test()
	public void timeAlert()
	{
		d.get("https://demoqa.com/alerts");
		
		d.findElement(By.xpath("//*[@id=\"timerAlertButton\"]")).click();
		
		WebDriverWait w=new WebDriverWait(d,5);
		
		w.until(ExpectedConditions.alertIsPresent());
		
		Alert a=d.switchTo().alert();
			
		System.out.println(a.getText());
		
		a.accept();
	}
	
	@Test
	public void confirmAlert1()
	{
		d.get("https://demoqa.com/alerts");
		
		d.findElement(By.xpath("//*[@id=\"confirmButton\"]")).click();
		
		Alert a=d.switchTo().alert();
		
		System.out.println(a.getText());
		
		a.accept();	
	}
	
	@Test
	public void promptAlert1() throws InterruptedException 
	{
		d.get("https://demoqa.com/alerts");
		
		d.findElement(By.xpath("//*[@id=\"promtButton\"]")).click();
		
		Alert a=d.switchTo().alert();
		
		d.switchTo().alert().sendKeys("Gowri");
		
		System.out.println(a.getText());
		
		a.accept();
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}