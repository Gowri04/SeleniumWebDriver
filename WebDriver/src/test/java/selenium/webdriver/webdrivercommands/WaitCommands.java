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
/*

Wait Commands
--------------
Wait commands direct the test execution to pause for a certain length of time before throwing exception.

Why do users need Selenium Wait?
---------------------------------
When a page loads on a browser, the various web elements that someone wants to interact with may load at various time intervals.

If an element is not located then the “ElementNotVisibleException” appears. 

Selenium Wait commands help resolve this issue. 

Implicit Waits
===============

1. Implicit wait directs the WebDriver to wait for a certain amount of time before it throw a "NoSuchElementException".
	 
2. The default setting is 0

To add implicit waits in test scripts, import the package:

import java.util.concurrent.TimeUnit;

driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

Implicit wait will accept 2 parameters:

	a. The first parameter will accept the time as an integer value and 
	b. The second parameter will accept the time measurement in terms of 
 
			§ SECONDS
			§ MINUTES
			§ MILISECOND
			§ MICROSECONDS
			§ NANOSECONDS
			§ DAYS
			§ HOURS
			
Explicit Wait
=============
1. By using Explicit Wait command, the WebDriver is directed to wait until a certain condition occurs before proceeding with executing the code.
	
2. Explicit wait can only be applied for specified elements. 

To declare explicit wait, we has to use “ExpectedConditions”. Expected Conditions can be used in Explicit Wait:

ExplictWait Methods
============================================
1. alertIsPresent()
2. elementSelectionStateToBe()
3. elementToBeClickable()
4. elementToBeSelected()
5. frameToBeAvaliableAndSwitchToIt()
6. invisibilityOfTheElementLocated()
7. invisibilityOfElementWithText()
8. presenceOfAllElementsLocatedBy()
9. presenceOfElementLocated()
10. textToBePresentInElement()
11. textToBePresentInElementLocated()
12. textToBePresentInElementValue()
13. titleIs()
14. titleContains()
15. visibilityOf()
16. visibilityOfAllElements()
17. visibilityOfAllElementsLocatedBy()
18. visibilityOfElementLocated()

To use Explicit Wait in test scripts, import the following packages into the script:

import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

Initialize A Wait Object using WebDriverWait Class:

WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
WebDriverWait wait = new WebDriverWait (driver, 20);

WebDriverWaitobjectname.until(ExpectedCondition.explicitmethods(locator)));

Example: 

Makes Web Driver wait for 20 sec(Initializing)
WebDriverWait wait = new WebDriverWait (driver, 20);

Makes Web Driver wait for 20 sec if given condition satisfies
wait.until(ExpectedConditions.VisibilityofElementLocated(By.xpath(""//button[@value='Save Changes']"")));

Difference between Implicit Wait and Explicit Wait
---------------------------------------------------

Implicit Wait	
-------------
Applies to all elements in a test script. 	
No need to specify “ExpectedConditions” on the element to be located	
Most effective when used in a test case in which the elements are located with the time frame specified in implicit wait	

Explicit Wait
-------------

Applies only to specific elements as intended by the user. 
Must always specify “ExpectedConditions” on the element to be located
Most effective when used when the elements are taking a long time to load. Also useful for verifying property of the element such as visibilityOfElementLocated, elementToBeClickable,elementToBeSelected

Fluent Waits
=============================================
Fluent Wait command defines the maximum amount of time for Selenium WebDriver to wait for a certain condition to appear. 

It also defines the frequency with which WebDriver will check if the condition appears before throwing the “ElementNotVisibleException”.

Syntax:
=============================================
Wait<WebDriver> wait = new FluentWait<WebDriver>(WebDriver reference)
.withTimeout(Duration.ofSeconds(SECONDS))
.pollingEvery(Duration.ofSeconds(SECONDS))
.ignoring(Exception.class);

WebElement e = wait.until(new Function<WebDriver, WebElement>() 
{ 
public WebElement apply(WebDriver d) 
	{
		return d.findElement(By.xpath("Xpath"));
	}
}
);

E.g…,
=============================================
Wait wait = new FluentWait<WebDriver>(driver)
.withTimeout(45, TimeUnit.SECONDS)
.pollingevery(5, TimeUnit.SECONDS)
.ignoring(NoSuchElementException.class);

WebElement e=wait.until(new Function<WebDriver, WebElement>()
{
	Public WebElement apply(WebDriver d)
	{
		Return d.findElement(By.xpath("//*[@id="Uname"]"));
	}
}
);

*/