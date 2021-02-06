package selenium.webdriver.webdrivercommands;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class NavigationCommands 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://www.seleniumeasy.com/");
	
		d.navigate().refresh();
		Thread.sleep(2000);
		
		d.navigate().to("https://www.seleniumeasy.com/test/");
		Thread.sleep(2000);
		
		d.navigate().forward();
		Thread.sleep(2000);
		
		d.navigate().back();
		Thread.sleep(2000);
	
		d.close();
	}
}
/*

Navigation Commands 
====================
	 
navigate.().to(String arg0):void= Loads a new web page in the current browser window. 
		
navigate.().back():void= Click the Back Button of any browser. 
		
navigate.().forward():void= Click the Forward Button of any browser. 
		
navigate.().refresh():void= Refresh the current page. 

*/