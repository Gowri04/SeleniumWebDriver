package selenium.webdriver.actionsclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
public class DragDrop 
{
	WebDriver d;
	
	@BeforeMethod
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		d=new ChromeDriver();
		
		d.manage().window().maximize();
	}
	
	@Test()
	public void dragDrop() throws Exception
	{
		d.get("https://demoqa.com/droppable");
		
		Thread.sleep(2000);	
		
		Actions a=new Actions(d); 
		
		WebElement source=d.findElement(By.xpath("//*[@id=\"draggable\"]"));
		
		WebElement target=d.findElement(By.xpath("//*[@id=\"droppable\"]"));
			
		a.clickAndHold(source);
		
		a.moveToElement(target);
		
		a.release();
		
		a.build();
		
		a.perform();
		
		//a.clickAndHold(source).moveToElement(target).release().perform(); 
		
		Thread.sleep(2000);	
	}
	
	@Test
	public void dragDrop1() throws Exception
	{
		d.get("https://demoqa.com/droppable");
		
		Actions a=new Actions(d);
		
		d.findElement(By.xpath("//*[@id=\"droppableExample-tab-accept\"]")).click();
		
		WebElement source=d.findElement(By.xpath("//*[@id=\"acceptable\"]"));
		
		WebElement source1=d.findElement(By.xpath("//*[@id=\"notAcceptable\"]"));
		
		WebElement target=d.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]"));
		
		a.dragAndDrop(source, target).build().perform();
		
		Thread.sleep(2000);
		
		a.clickAndHold(source1).moveToElement(target).build().perform();
		
		Thread.sleep(2000);
	}
	
	@Test
	public void dragDrop2()
	{
		d.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		WebElement source = d.findElement(By.xpath("//*[@id='box6']"));  
		
		WebElement target = d.findElement(By.xpath("//*[@id='box107']"));
		
		Actions act = new Actions(d);
		
		//act.clickAndHold(source).moveToElement(target).release().build().perform(); // First method  
		
		act.dragAndDrop(source, target).build().perform(); // Second method
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}