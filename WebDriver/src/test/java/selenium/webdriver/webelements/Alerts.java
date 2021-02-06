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
/*

Alert is an interface.

Alert is a pop up window that comes up on screen. 

Alerts are blocking in nature. 

Simple alerts just have a OK button. Display some information or warning on the screen to the user 

Confirmation alert have an option to accept or dismiss the alert.

Prompt Alert we get an option to add text to the alert box. Used when some input is required from the user. 

Switch Commands
===============

switchTo() method is used to switch between frames,alerts and windows to move from one to another using WebDriver.

Switch to Frame by Index= switchTo().frame(index)

Switch to Frames by Name= switchTo().frame(name)
		
Switch to Frame by ID= switchTo().frame(id)
		
Switch to Frame by WebElement= switchTo().frame(WebElement)
		
Switch to default Content(switch back to main page)= switchTo().defaultContent()

d.switchTo().alert();
		
d.switchTo().frame(0);
		
d.switchTo().window(null);

*/