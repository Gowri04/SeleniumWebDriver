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
/*

iFrame
--------
iFrame is a HTML document embedded inside an HTML document. 

iFrame is defined by an <iframe> </iframe> tag in HTML.
 
We can use the switchTo().frame() in three ways:

switchTo.frame(int frameNumber): Pass the frame index and driver will switch to that frame.

switchTo.frame(string frameNameOrId): Pass the frame element Name or ID and driver will switch to that frame.

switchTo.frame(WebElement frameElement): Pass the frame web element and driver will switch to that frame.

switchTo().defaultContent(): which switches the driver back to the main page.

What is a frame index?
-----------------------

Index of an iFrame is the position at which it occurs in the HTML page.

How to find total number of iFrames on a webpage?
-------------------------------------------------

Executing a JavaScript
======================
//By executing a java script

JavascriptExecutor exe = (JavascriptExecutor) driver;
Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
System.out.println("Number of iframes on the page are " + numberOfFrames);
		
Tag Name
=========	 

//By finding all the web elements using iframe tag name

List<WebElement> iframeElements driver.findElements(By.tagName("iframe"));
System.out.println("The total number of iframes are " + iframeElements.size());


*/