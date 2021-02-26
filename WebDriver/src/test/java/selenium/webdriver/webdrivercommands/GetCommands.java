package selenium.webdriver.webdrivercommands;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class GetCommands 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		WebDriver d=new ChromeDriver();
	
		d.get("https://www.seleniumeasy.com/");
		
		System.out.println(d.getCurrentUrl());
		
		System.out.println(d.getPageSource());
		
		System.out.println(d.getTitle());

		d.close();
	}
}
