package selenium.webdriver.webelements;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
public class DropDown 
{
	WebDriver d;
	
	@BeforeMethod
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		d=new ChromeDriver();
		
		d.manage().window().maximize();
		
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void dropDown() 
	{
		d.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

		WebElement dropdown=d.findElement(By.xpath("//select[@id='select-demo']"));
		
		Select s=new Select(dropdown);
		
		//s.selectByIndex(1);
		//Thread.sleep(2000);
		
		//s.selectByValue("Sunday");
		//Thread.sleep(2000);
	
		s.selectByVisibleText("Sunday");
		
		WebElement message=d.findElement(By.xpath("//p[@class='selected-value']"));
		System.out.println(message.getText());	
	}
	
	@Test
	public void dualDropDown()
	{
		d.get("https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
		
		WebElement listbox=d.findElement(By.xpath("//select[@class='form-control pickListSelect pickData']"));
		
		WebElement listbox1=d.findElement(By.xpath("//*[@id=\"pickList\"]/div/div[3]/select"));
		
		WebElement add=d.findElement(By.xpath("//*[@id=\"pickList\"]/div/div[2]/button[1]"));
		
		Select s=new Select(listbox);
	
		if(s.isMultiple())
		{
			s.selectByIndex(0);
			s.selectByIndex(3);
			add.click();	
			System.out.println(listbox1.getText());
		}
		else
		{
			System.out.println("Not a multiselect");
		}	
	}
	@AfterMethod
	public void tearDown() 
	{
		d.close();
	}
}
/*

Select Class
=============

Select is a class used to perform multiple operations on Dropdown and Multiple Select objects. 

selectByIndex(int arg0):void 

selectByVisibleText(String arg0):void

deselectAll():void 
			
deselectByIndex(int arg0):void 
			
deselectByValue(String arg0):void 
			
deselectByVisibleText(String arg0):void 
			
isMultiple():boolean 

*/