package com.autotrader.helper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.autotrader.pages.HomePage;

public class AutotraderHelper

{   
	// importing Selenium package (Webdriver actually means WebDriver)
	private static WebDriver driver ;
	private static Select select;
	
	static
	{
		
		driver= null;
	}

	public static WebElement getElementByID(String id) throws Exception
	{
	By locator = By.id(id)	;
	return getElement(locator);
	}
	
	public static WebElement getElementByClassName(String ClassName) throws Exception
	{
	By locator = By.className(ClassName);
	return getElement(locator);
	}
	
	public static WebElement getElementByname(String name) throws Exception
	{
	By locator = By.name(name)	;
	return getElement(locator);
	}
	
	public static WebElement getElementByCaseSelector(String cssSelector) throws Exception
	{
	By locator = By.cssSelector(cssSelector)	;
	return getElement(locator);
	}
	
	public static WebElement getElementByXpath(String xpath) throws Exception
	{
	By locator = By.id(xpath)	;
	return getElement(locator);
	}
	//////////////////////////////
	
	public static  List<WebElement> getElementsByID(String id) throws Exception
	{
	By locator = By.id(id)	;
	return getElements(locator);
	}
	
	public static List<WebElement> getElementsByClassName(String ClassName) throws Exception
	{
	By locator = By.className(ClassName);
	return getElements(locator);
	}
	
	public static List<WebElement> getElementsByname(String name) throws Exception
	{
	By locator = By.name(name);
	return getElements(locator);
	}
	
	public static List<WebElement> getElementsByCaseSelector(String cssSelector) throws Exception
	{
	By locator = By.cssSelector(cssSelector)	;
	return getElements(locator);
	}
	
	

		
	public static List<WebElement> getElementsByXpath(String xpath) throws Exception
	{
	By locator = By.id(xpath)	;
	return getElements(locator);
	}
	
	
	private static WebElement getElement(By lcoator) throws Exception 
	
	{
		WebElement element= null;
		int tryCount = 0;
		while(element == null)
		{
			try
			{
			element= driver.findElement(lcoator);
			
			}catch(Exception e)
						{
				if ( tryCount ==3)
				{
				 throw e;	
				}
				Thread.sleep(2000);
				tryCount++;
			}
		}
		
		
		return element;
	}
	
	public static void selectByIndex(WebElement element, int index) throws Exception
	{
		select = new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element, String value) throws Exception
	{
		select = new Select(element);
		select.selectByValue(value);
	}
	
	public static void selectByText(WebElement element, String text) throws Exception
	{
		select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void launchBrowser(String browser) throws Exception
	
	{
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver = initialiseChrome();
			break;
		case "firefox":
			driver = initialiseFirefox();
			break;
			default :
				System.out.println(browser + " is not recognised and firefox is lanuched ");
				driver = initialiseFirefox();
		
		}
	}
	
	public static void launchUrl (String Url)
	{
		driver.navigate().to(Url);
		
	}
	
	
	public static void closeBrowser() throws Exception
	{
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
	private static WebDriver initialiseChrome() throws Exception
	
	{
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	
private static WebDriver initialiseFirefox() throws Exception
	
	{
		driver = new FirefoxDriver();
		return driver;
	}
	
	
	public static  File takeScreenShot() throws Exception
	{
	
		return  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//return FileUtils.copyFile(srcFile, new File("./Screenshots/screenshot" + timeNow + ".png" ));
			
	}

	public static void saveScreenshot() throws Exception
	{
		String timeNow = new SimpleDateFormat("hh:mm:ss").format(new GregorianCalendar().getTime());
		File screenShot = takeScreenShot();
		FileUtils.copyFile(screenShot, new File("./Screenshots/screenshot" + timeNow + ".png" ));
		
	}
	
private static List<WebElement> getElements(By lcoator) throws Exception 

{
	List <WebElement> element= null;
	int tryCount = 0;
	while(element == null)
	{
		try
		{
		element=driver.findElements(lcoator);
		
		}catch(Exception e)
					{
			if ( tryCount ==3)
			{
			 throw e;	
			}
			Thread.sleep(2000);
			tryCount++;
		}
	}
	
	
	return element;
}


public HomePage GivenINavigateAutotraderHomePage() throws Exception
{
	launchUrl("http://www.autotrader.co.uk/");
	return new HomePage();
}


}
