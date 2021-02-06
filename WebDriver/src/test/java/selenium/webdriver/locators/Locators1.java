package selenium.webdriver.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators1 
{
 public static void main(String[] args) 
 {
  
	 System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	 
	 driver.get("http://automationpractice.com/index.php");
	  
	 driver.manage().window().maximize(); // maximize web page
	  
	 // id & name locators
	 WebElement searchbox=driver.findElement(By.id("search_query_top"));
	 searchbox.sendKeys("T-shirts");
	  
	 driver.findElement(By.name("submit_search")).click();
	
	 //linkText & partial linkText
	 //driver.findElement(By.linkText("Printed Chiffon Dress")).click();
	 driver.findElement(By.partialLinkText("Chiffon Dress")).click();
 }
}
/*

Locators 
=========

Identify WebElements uniquely within the WebPage

Types of Locators
=================

id

name

className

cssSelector

xPath

linkText

partialLinkText

tagName

setProperty in Selenium
-------------------------
Set the properties for the desired browser to be used in test automation.

The setProperty method has two attributes:
“propertyName” - name of the browser-specific driver
“propertyvalue.”- path of that browser driver.

System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");

use of setProperty method
----------------------------
Once the driver is downloaded for a specific browser, QAs need the setProperty() method to define the path for that driver before writing any test cases.
This helps the Selenium WebDriver identify the browser on which tests are to be executed.

Thread.sleep() 
----------------
Thread.sleep() is used, the code will pause for the specified period of time.





*/