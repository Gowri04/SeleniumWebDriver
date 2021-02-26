package selenium.webdriver.advance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModel 
{
	WebDriver localDriver;
	
	public PageObjectModel(WebDriver remoteDriver) 
	{
		localDriver=remoteDriver;
		PageFactory.initElements(localDriver, this);
	}
	
	@FindBy(how=How.XPATH, using= "//*[@id=\"welcome\"]")
	WebElement welcomeProfile;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"welcome-menu\"]/ul/li[2]/a")
	WebElement logout;
	
	public void clickWelcomeProfile()
	{
		welcomeProfile.click();
	}
	
	public String getHomePageTitle()
	{
		String homePageTitle=localDriver.getTitle();
		return homePageTitle;
	}
	
	public void clickLogoutButton()
	{
		logout.click();
	}
}
/*

Page Object Model
==================
 
POM is a Design pattern which creates an object repository to store all the web elements.

For each web page there should be a separate page class.

In page class will have all object locators and action methods.

Page Factory 
============

Page Factory is a class used to support Page Object Design patterns. 

In Page Factory, we use @FindBy annotation. 

The initElements method is used to initialize web elements.
 
@FindBy
=======

An annotation used in Page Factory to locate and declare web elements using different locators.
 
initElements()
=============== 

initElements is a static method in Page Factory class. 

Using the initElements method, one can initialize all the web elements located by @FindBy annotation.
 
lazy initialization
===================
AjaxElementLocatorFactory is a lazy load concept in Page Factory. 

This is used to identify web elements only when they are used in any operation or activity. 

The timeout of a web element can be assigned to the object class with the help of the AjaxElementLocatorFactory.

Page Object Model
=================
Finding web elements using By
Page Object Model is a design pattern
In POM, one needs to initialize every page object individually
POM does not provide lazy initialization


Page Factory
=============
Finding web elements using @FindBy
Page Factory is a class which provides implementation of Page Object Model design pattern
In Page Factory, all page objects are initialized by using the initElements() method
Page Factory does provide lazy initialization



*/
