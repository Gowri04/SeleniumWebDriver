package selenium.webdriver.webdrivercommands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserCommands 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		
		d.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/a")).click();
		Thread.sleep(4000);
		
		//d.close(); 
		
		d.quit();
	}
}
/*

Browser Commands
================

close():void= Close only the current window controlled by the WebDriver.

quit():void= Closes all windows opened by the WebDriver. 

WebElements Commands
====================

sendKeys(CharSequence… keysToSend):void= Used to pass the values to the element.

clear():void= Clear the value in the text field of the element.

click():void= Used to click an element. 

submit():void= Used to submit a form.

*/