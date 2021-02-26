package selenium.webdriver.webelements;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class WebTables 
{
	WebDriver d;
	
	@BeforeMethod
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		d=new ChromeDriver();
		
		d.manage().window().maximize();
	}
	
	@Test
	public void webTables() throws Exception
	{
		d.get("http://the-internet.herokuapp.com");
		d.findElement(By.linkText("Sortable Data Tables")).click();
		
		//get number of columns and print column names
		List<WebElement> columns=d.findElements(By.xpath("//table[@id='table1']//tr//th"));
		System.out.println("NUmber of columns : "+columns.size());
		for (WebElement col : columns) 
		{
			System.out.println("Columns are : "+col.getText());
		}
	
		//get number of rows
		List<WebElement> rows=d.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Number of rows : "+rows.size());
		for (WebElement row : rows) 
		{
			System.out.println("Rows are : "+row.getText());
		}
	
		//get content
		System.out.println("Cell content is " +selectTableContent(2, 3));
		Thread.sleep(3000);
	}
	public String selectTableContent(int row, int column)
	{
		String content=d.findElement(By.xpath("//table[@id='table1']//tr["+row+"]/td["+column+"]")).getText();
	
		return content;
	}
	
	@Test
	public void webTables_ToolsQA() throws Exception
	{
		d.get("https://demoqa.com/webtables");
		
		//getting Column Details
		List <WebElement> col=d.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]"));
		int col_size=col.size();
		System.out.println("No.of Column: "+col_size);
		System.out.println("Columns names are:");
		for(WebElement col_Details:col)
		{
			String col_Names=col_Details.getText();
			System.out.print(col_Names+" ");
		}
		
		//getting Row Details
		List <WebElement> row=d.findElements(By.xpath("//div[@class='rt-tbody']"));
		int row_size=row.size();
		System.out.println("No.of Rows: "+row_size);
		
		for(int i=1;i<=row_size;i++)
		{
			List <WebElement> row_details=d.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div["+i+"]/div[1]"));
			for(WebElement erow_detail:row_details)
			{
				String row_values=erow_detail.getText();
				System.out.print(row_values+" ");
			}
		}
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() 
	{
		d.close();
		
	}
}
