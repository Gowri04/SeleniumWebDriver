package selenium.webdriver.testNG;
import org.testng.annotations.Test;
public class Prioritization 
{
	@Test(priority=0)
	public void test1()
	{
		System.out.println("Test1");
	}

	@Test(priority=-1)
	public void test2()
	{
		System.out.println("Test2");
	}
	@Test(priority=1)
	public void test3()
	{
		System.out.println("Test3");
	}
	@Test(priority=-2)
	public void test4()
	{
		System.out.println("Test4");
	}
	@Test(priority=(int)0.5)
	public void test5()
	{
		System.out.println("Test5");
	}
	@Test(priority=0)
	public void test6()
	{
		System.out.println("Test6");
	}
	@Test(enabled=false) //Skipping test
	public void test7()
	{
		System.out.println("Test7");
	}
	@Test(invocationCount=2) //Skipping test
	public void test8()
	{
		System.out.println("Test8");
	}
}
