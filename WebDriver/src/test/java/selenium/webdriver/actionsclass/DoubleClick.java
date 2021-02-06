package selenium.webdriver.actionsclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
public class DoubleClick 
{
	WebDriver d;
	
	@BeforeMethod
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		d=new ChromeDriver();
		
		d.manage().window().maximize();
	}
	
	@Test
	public void doubleClick() throws Exception
	{
		d.get("https://demoqa.com/buttons");
		
		Actions a=new Actions(d);
		
		WebElement doubleclick=d.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/button"));
	
		a.doubleClick(doubleclick).build().perform();
		
		Thread.sleep(2000);
	}
	
	@Test
	public void doubleClick1() throws InterruptedException
	{
		d.get("http://api.jquery.com/dblclick/");

		Actions act = new Actions(d);

		d.switchTo().frame(0);

		WebElement ele = d.findElement(By.xpath("/html/body/div"));

		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
		// ele);// scroll down for the element

		String color = ele.getCssValue("color").toString();
		System.out.println("color before double click:" + color); // blue

		Thread.sleep(5000);
		act.doubleClick(ele).build().perform();

		Thread.sleep(2000);
	  	color = ele.getCssValue("color").toString();
	  	System.out.println("color after double click:" + color); // yellow
		
	  	Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();	
	}
}
/*

Action Class- Interface

Only used to represent a single user interaction to perform series of action items build by actions class
 
Actions Class-Class

Collection of individual action that we want to perform.
Implements the builder design pattern.
User facing API for emulating complex user gestures.

Design Pattern

Builds a composite action containing all actions specified by the method calls.	

How to use Actions Class in Selenium?

    1. Import org.openqa.selenium.interactions.Actions and import org.openqa.selenium.interactions.Action package of WebDriver API.
    2. Instantiate the Actions Class
    3. Generate actions sequence
    4. Build actions sequence
    5. Perform actions sequence
 
Build() 

Used to generate a composite action containing all actions. 
build() is executed in the perform() internally.

Perform() 

Performs the actions we have specified, it internally invokes build() method first. 
 
Modifier Key

Key that modifies the action of another key when the two are pressed together like Shift, Control & Alt.

Difference

Actions is a class that is based on a builder design pattern.  
This is a user-facing API for emulating complex user gestures.

Action is an Interface which represents a single user-interaction action.
It contains one of the most widely used methods perform().

Mouse Events

click(): Clicks at the current mouse location.
doubleClick(): Performs a double-click at the current mouse location.
contextClick() : Performs a context-click at middle of the given element.
clickAndHold(): Clicks (without releasing) in the middle of the given element.
dragAndDrop(source, target): Click-and-hold at the location of the source element, moves to the location of the target element
moveToElement(toElement): Moves the mouse to the middle of the element
release(): Releases the depressed left mouse button at the current mouse location

Keyboard Events

keyDown(modifier key): Performs a modifier key press. 
sendKeys(keys to send ): Sends keys to the active web element.
keyUp(modifier key): Performs a modifier key release.


*/