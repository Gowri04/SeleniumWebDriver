package selenium.webdriver.locators;
interface SearchContent
{
	void findElement();
	void findElements();
}
interface WebDriver extends SearchContent
{
	void get();
	void close();
}
class RemoteWebDriver implements WebDriver
{
	@Override
	public void findElement() 
	{	
		System.out.println("Overrided the findElement");
	}
	@Override
	public void findElements() 
	{
		System.out.println("Overrided the findElements");
	}
	@Override
	public void get() 
	{
		System.out.println("Overrided the get()");
	}
	@Override
	public void close() 
	{
		System.out.println("Overrided the close()");
	}
}
class ChromeDriver extends RemoteWebDriver
{
	public void get()
	{
		System.out.println("");
	}
	public void close()
	{
		System.out.println("");
	}
}
class EdgeDriver extends RemoteWebDriver
{
	public void get()
	{
		System.out.println("");
	}
	public void close()
	{
		System.out.println("");
	}
}
public class WebDriverConcept 
{
	
}