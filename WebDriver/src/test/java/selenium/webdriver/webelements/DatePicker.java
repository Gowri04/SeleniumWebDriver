package selenium.webdriver.webelements;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.*;

public class DatePicker 
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
	public void datePicker1() 
	{
		String month="April";
		String year="2020";
		int date=22;
		
		d.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");

		d.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]")).click();
		
		while(true)
		{
			String m_y=d.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[2]/th[2]")).getText();
			String[] split=m_y.split(" ");
			
			if(month.equals(split[0]) && year.equals(split[1]))
			{
				break;
			}
			else
			{
				d.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[2]/th[1]")).click();
			}
		}
		
		d.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[4]/td[4]")).click();
	}
	
	@Test
	public void datePicker() 
	{
		d.get("https://www.demoqa.com/date-picker");
		
		d.findElement(By.xpath("//*[@id=\"datePickerMonthYearInput\"]")).click();
	
		WebElement month=d.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
		WebElement year=d.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
		
		Select s=new Select(month);
		s.selectByVisibleText("October");
	
		Select s1=new Select(year);
		s1.selectByVisibleText("2021");

		d.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]")).click();
	}
	
	@Test
	public void datePicker2() throws AWTException 
	{
		d.get("https://www.phptravels.net/home");
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	
		//Clicking Check-in Button
		
		d.findElement(By.xpath("//*[@id='checkin']")).click();

		String Month_Exp="June,";
		String year_Exp="2021";
		int date=7;
		
		while(true)
		{
			//Getting the Month and Year from the Calendar.
			String month_Scr=d.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/nav[1]/div[2]")).getText();
			//Splitting the Month and Year as an array
			String Split_Month[]=month_Scr.split("\n");
			//Checking the month and year
			if((Month_Exp.equals(Split_Month[0])) && (year_Exp.equals(Split_Month[1])))
			{
				break;//if it is true it breaks the loop
			}
			else	
			{	
				//if it is false it click the next month button
				d.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/nav[1]/div[3]")).click();
			}
		}
		//selecting the Date in the calendar
		d.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div["+date+"]")).click();
	}

	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}
