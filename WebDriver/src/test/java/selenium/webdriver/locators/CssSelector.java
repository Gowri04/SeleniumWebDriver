package selenium.webdriver.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class CssSelector 
{
 public static void main(String[] args) 
 {
	 System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
	 
	 WebDriver driver=new ChromeDriver();
  
	 driver.get("https://www.facebook.com/");
	
	 driver.manage().window().maximize(); 
	
	 //Tag & ID
	 //driver.findElement(By.cssSelector("input#email")).sendKeys("David");
	 //driver.findElement(By.cssSelector("#email")).sendKeys("David");
	  
	 // Tag & Class
	 //driver.findElement(By.cssSelector("input.inputtext")).sendKeys("John");
	 //driver.findElement(By.cssSelector(".inputtext")).sendKeys("John");
	  
	 //Tag & attribute
	 //driver.findElement(By.cssSelector("[name=email]")).sendKeys("Smith");
	 //driver.findElement(By.cssSelector("input[name=email]")).sendKeys("Smith");
	 
	 //Tag , class & attribute
	 driver.findElement(By.cssSelector("input.inputtext[data-testid=royal_email]")).sendKeys("Smith");
	 
	 driver.findElement(By.cssSelector("input.inputtext[data-testid=royal_pass]")).sendKeys("abc");
 }
}