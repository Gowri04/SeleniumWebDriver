package selenium.webdriver.testNG;
import org.testng.annotations.*;
public class Annotations 
{
	@BeforeSuite
	public void beforeSuite() 
	{
		System.out.println("Runs before all <test> tag in this suite have run.");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Run before all the classes in the <test> tag in the suite have run");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Runs Before all the test methods in the current class invoked");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Execute Before Each Test Method");
	}
	@Test
	public void test1()
	{
		System.out.println("Part of Test Case1");
	}
	@Test
	public void test2()
	{
		System.out.println("Part of TestCase2");
	}
	@Test
	public void test3()
	{
		System.out.println("Part of TestCase3");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Execute After Each Test Method");
	}
	@AfterClass
	public void afterClass() 
	{
		System.out.println("Runs after all the test methods in the current class is invoked");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("Runs after all the classes in the <test> tag in the suite have run");
	}
	
	@AfterSuite
	public void afterSuite() 
	{
		System.out.println("Runs after all <test> tag in this suite have run.");
	}
}
/*


Annotations are used to control the flow of the execution of tests.

Why Use Annotations? Benefits of Annotations?
	1. Easy To Learn ,Execute 
	2. Can Be Parameterized 
	3. Strongly Typed– Errors can be encountered during the run time
	4. No Need To Extend Any Class

*/