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
	  
	 driver.manage().window().maximize(); 
	  
	 //id locators
	 WebElement searchbox=driver.findElement(By.id("search_query_top"));
	 searchbox.sendKeys("T-shirts");
	
	 //name locators
	 driver.findElement(By.name("submit_search")).click();
	
	 //linkText & partial linkText
	 //driver.findElement(By.linkText("Printed Chiffon Dress")).click();
	 driver.findElement(By.partialLinkText("Chiffon Dress")).click();
 }
}
