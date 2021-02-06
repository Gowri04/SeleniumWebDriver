package selenium.webdriver.webdrivercommands;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class GetCommands 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		WebDriver d=new ChromeDriver();
	
		d.get("https://www.seleniumeasy.com/");
		
		System.out.println(d.getCurrentUrl());
		
		System.out.println(d.getPageSource());
		
		System.out.println(d.getTitle());

		d.close();
	}
}
/*

Get Commands 
============

get(String arg0):void= Load a new web page in the current browser window.

getTitle():String= Fetches the Title of the current page. 

getText():String= Fetch the innerText of the element. Returns an inner Text of the element
	
getCurrentUrl():String= Fetches the Current URL which is opened in the browser. 
		
getPageSource():String= Returns the Source Code of the page. 
		
getTagName():String= Gets the tag name of this element. 
		
getCssvalue():String= Fetch CSS property value of the give element. 
		
getSize():Dimension= Fetch the width and height of the rendered element. Returns the size of the element on the page.
	
getLocation():Point= Locate the location of the element on the page. This returns the Point object, from which we can get X and Y coordinates of specific element.

getWindowHandle();

getWindowHandles();


*/