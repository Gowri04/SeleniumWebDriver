package selenium.webdriver.webelements;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class IFrame 
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
	public void iFrame() 
	{
		d.get("https://demoqa.com/frames");
		
		d.switchTo().frame(0);
		
		//d.switchTo().frame("frame1");
		
		WebElement frame1=d.findElement(By.xpath("//*[@id=\"sampleHeading\"]"));
		
		//d.switchTo().frame(frame1);
		
		System.out.println(frame1.getText());
		
		d.switchTo().defaultContent();
		
		d.switchTo().frame(1);
		
		WebElement frame2=d.findElement(By.xpath("//*[@id=\"sampleHeading\"]"));
		
		System.out.println(frame2.getText());	
	}
	
	@Test
	public void countNoofIFramesUsingWebElement()
	{
		d.get("https://demoqa.com/frames");
		
		//By finding all the web elements using iframe tag
		
		List <WebElement> noOf_IFrames=d.findElements(By.tagName("iframe")); 
		
		int noOfIFrames=noOf_IFrames.size();
		
		System.out.println("No.of Iframes in WebPages: "+noOfIFrames);
	}
	
	@Test
	public void countNoofIFramesUsingJS()
	{
		d.get("https://demoqa.com/frames");
		
		JavascriptExecutor js=((JavascriptExecutor)d); //By executing a java script
		
		String noofframes=js.executeScript("return window.length;").toString();
		
		Integer noofframes1=Integer.parseInt(noofframes);
		
		System.out.println("No of Iframes in WebPages: "+noofframes1);
		
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();	
	}
}