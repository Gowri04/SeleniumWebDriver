package selenium.webdriver.webelements;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class RadioButton 
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
	public void radioButton() 
	{
		d.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		
		WebElement female=d.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[2]/input"));
		
		WebElement male=d.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input"));
		
		WebElement getCheckedValue=d.findElement(By.xpath("//button[@id='buttoncheck']"));
		
		WebElement message=d.findElement(By.xpath("//p[@class='radiobutton']"));
		
		if(female.isEnabled())
		{
			female.click();
			System.out.println(female.isSelected());
			getCheckedValue.click();
			System.out.println(message.getText());
			
			if (male.isEnabled())
			{
				male.click();
				System.out.println(male.isSelected());
				getCheckedValue.click();
				System.out.println(message.getText());
			}
		}
		else 
		{
			System.out.println("Radio Button is not enabled");
		}	
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}
