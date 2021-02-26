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


Action Class

	1. Action Class is an Interface.
	2. Action Class is only used to represent a single user interaction to perform series of action items build by actions class.

Actions Class

	1. Actions Class is a class.
	2. Actions Class is a collection of individual action that we want to perform.
	3. Actions Class implements the builder design pattern(builds a composite action containing all actions specified by the method calls)
	4. Actions Class is a user facing API for emulating complex user gestures.
	
How to use Actions Class in Selenium?

	1. Import org.openqa.selenium.interactions.Actions and import org.openqa.selenium.interactions.Action package of WebDriver API.
	2. Instantiate the Actions Class
	3. Generate actions sequence
	4. Build actions sequence
	5. Perform actions sequence



Build

	1. build() method is used to generate a composite action containing all actions. 
	2. But if you observe, we have not invoked it in our above command. 
	3. The build is executed in the perform method internally.

Perform

	1. perform() method performs the actions we have specified. 
	2. But before that, it internally invokes build() method first. 
	3. After the build, the action is performed.

Modifier Key

Key that modifies the action of another key when the two are pressed together like Shift, Control & Alt.

Methods in Actions Class

	1. Keyboard Events
	2. Mouse Events



 Keyboard Event
	1. Keyboard events�generate by pressing a key or a combination of keys on a keyboard. 
	2. Which, in turn, enables currently running programs to respond to the data entered by pressed key/keys.

Why do we need Keyboard Events in Automation Test?

	1. Firstly, in most of the Web Applications, features functionalities are available on the press of Shortcut keys. For instance, the most commonly used feature of most widely used text editor software like Word document is Copy & Paste. Shortcut keys CTRL+C and CTRL+V, respectively, perform this function. In other words, the combination of Control and C or Control and V is tested to check such shortcut keys functionality. The sendKeys() method is unable to perform this action of multiple key combinations.
	2. Secondly, sometimes, some instances require interaction with Desktop components & type text into it. For instance, to upload any file as an email attachment, we have to enter the file name on Windows Dialog. sendKeys() method is unable to perform this action as Selenium WebDriver works with the web. Therefore, it�s unable to identify theWindows dialog box.


Keyboard Events

	1. keyDown(CharSequence key): Performs a modifier key press.�
	2. keyDown(WebElement target, CharSequence key): Performs a modifier key press after focusing on an element.
	3. keyUp(CharSequence key): Performs a modifier key release.
	4. keyUp(WebElement target, CharSequence key): Performs a modifier key release after focusing on an element.
	5. sendKeys(CharSequence keys): Sends keys to the active element.
	6. sendKeys(WebElement target, .CharSequence keys) : Equivalent to calling: Actions.click(element).sendKeys(keysToSend)
Mouse Events

	1. click()
	
	Clicks at the current mouse location.
	
	2. doubleClick(WebElement)
	
	Performs a double-click at the current mouse location.
	
	3. contextClick(WebElement) 
	
	Performs a context-click at middle of the given element.
	
	4. clickAndHold()
	
	Clicks (without releasing) in the middle of the given element.
	
	5. dragAndDrop(WebElement source,  WebElement target )
	
	Click-and-hold at the location of the source element, moves to the location of the target element.
	
	Or
	
	This method performs left click, hold the click to hold the source element, moves to the location of the target element and then releases the mouse click.
	
	6. dragAndDropBy(WebElementsource, xOffset, yOffset)
	
	Click-and-hold at the location of the source element, moves by a given offset.
	
	7. moveByOffset(x-offset, y-offset)
	
	Moves the mouse from its current position (or 0,0) by the given offset.
	
	8. moveToElement(WebElement target or toElement)
	
	Moves the mouse to the middle of the element.
	
	9. moveToElement(WebElement target, int xOffset, int yOffset)
	Moves the mouse to an offset from the top-left corner of the element
	
	10. release()
	
	Releases the depressed left mouse button at the current mouse location.
	
https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html















*/