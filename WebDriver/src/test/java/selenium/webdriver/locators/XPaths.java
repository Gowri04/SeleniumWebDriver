package selenium.webdriver.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class XPaths 
{
 public static void main(String[] args) 
 {
	  System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
	  
	  WebDriver driver=new ChromeDriver();
	  
	  driver.get("http://automationpractice.com/index.php");
	  
	  driver.manage().window().maximize();
	  
	  //Absolute xpath
	  //driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/input[4]")).sendKeys("T-shirts");
	  //driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
	  
	  //Relative xpath
	  //driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-shirts");
	  //driver.findElement(By.xpath("//button[@name='submit_search']")).click();
	  
	  
	  //xpath with   'or'
	  
	  //driver.findElement(By.xpath("//input[@id='search_query_top' or @name='search_queryX']")).sendKeys("T-shirts");
	  //driver.findElement(By.xpath("//button[@name='submit_searchX' or @class='btn btn-default button-search']")).click();
	   
	  //xpath with 'and'
	  //driver.findElement(By.xpath("//input[@id='search_query_top' and @name='search_query']")).sendKeys("T-shirts");
	  //driver.findElement(By.xpath("//button[@name='submit_search' and @class='btn btn-default button-search']")).click();
	  
	  //xpath with contains()
	  //driver.findElement(By.xpath("//input[contains(@id,'query_top')]")).sendKeys("T-shirts"); // id=search_query_top
	  //driver.findElement(By.xpath("//button[contains(@name,'search')]")).click(); // name=submit_search
	  
	  //xpath with start-with()
	  //driver.findElement(By.xpath("//input[starts-with(@id,'search_query')]")).sendKeys("T-shirts"); // id=search_query_top
	  //driver.findElement(By.xpath("//button[starts-with(@name,'submit_')]")).click(); // name=submit_search
	  
	  //xpath with text()
	  //driver.findElement(By.xpath("//a[text()='Women']")).click();   // WOMEN Tab
	  
	  //chained xpath
	  
	  driver.findElement(By.xpath("//form[@id='searchbox']//input[@id='search_query_top']")).sendKeys("T-shirts");
	  driver.findElement(By.xpath("//form[@id='searchbox']//button[@name='submit_search']")).click(); 
 }
}