package selenium.webdriver.webdrivercommands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ConditionalCommands 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		Thread.sleep(2000);
		
		WebElement checkbox=d.findElement(By.xpath("//*[@id=\"isAgeSelected\"]"));
		WebElement text=d.findElement(By.xpath("//*[@id=\"txtAge\"]"));
	
		System.out.println(checkbox.isDisplayed());
		
		System.out.println(checkbox.isEnabled());
	
		for(int i=0;i<=2;i++)
		{
			System.out.println(checkbox.isSelected());
			checkbox.click();
			Thread.sleep(2000);
			System.out.println(text.getText());
		}
		d.close();
	}
}
/*

Conditional Commands
=====================

isSelected():boolean
=====================

Used to verify whether a certain check box, radio button, or option in a drop-down box is selected. 

It does not work on other elements. 

isDisplayed():boolean
=====================

Used to verify whether a certain element is displayed or not before executing a command. 
				
isEnabled():boolean
====================

Used to verify whether a certain element is enabled or not before executing a command. 	

*/