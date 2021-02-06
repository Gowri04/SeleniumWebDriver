package selenium.webdriver.testNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TestNGDataProvider
{
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod()
	{
		return new Object[][] 
		{ 
			{"First-Value"}, {"Second-Value"} 
		};
	
	}

	@Test (dataProvider = "data-provider")
    public void myTest (String val) 
    {
        System.out.println("Passed Parameter Is : " + val);
    }
}
/*
Inherited DataProvider In TestNG
 
Dataprovider and the test case method can also be in two different classes. 

It is inheriting the dataprovider since we are inheriting it from another file.

It’s required to slightly improve the above code to run the test case like this.

*/