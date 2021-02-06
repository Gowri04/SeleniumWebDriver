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
/*
XPath
=====

1. XPath is defined as XML path

2. It is a syntax or language for finding any element on the web page using XML path expression

3. XPath is used to find the location of any element on a WebPage using HTML DOM structure

4. XPath can be used to navigate through elements and attributes in DOM

Types of XPath
==============

Absolute XPath
	
Relative XPath

Absolute XPath
==============

Direct way to find the element

Starts with single forward slash(/) ,which means you can select the element from the root node.

html/body/div[1]/section/div[1]/div/div/div/div[1]/div/div/div/div/div[3]/div[1]/div/h4[1]/b

Disadvantage of the Absolute XPath 
==================================

If there are any changes made in the path of the element then that XPath gets failed.

Relative XPath
==============

Starts from the middle of the HTML DOM structure. 

Start with the double forward slash (//), which means it can search the element anywhere at the WebPage.

// tagname[@attribute-name=’value1’]

Using single attribute
======================

//*[@class='featured-box']

// a [@href=’http://www.google.com’]

Using multiple attribute 
========================

//tagname[@attribute1=’value1’][@attribute2=’value2’]

//a[@id=’id1’][@name=’namevalue1’] 

Using contains method 
=====================

//tagname[contains(@attribute,’value1’)] 

Examples //input[contains(@id,’’)]

Using starts-with method 
========================

//tagname[starts-with(@attribute-name,’xxx ’)]

Examples: //id[starts-with(@id=’ ’)]

Using text method 
==================

//a[text()='Women']

Using chained XPath
====================

//form[@id='searchbox']//input[@id='search_query_top']


*/