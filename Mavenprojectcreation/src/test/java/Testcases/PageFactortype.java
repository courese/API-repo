package Testcases;

import java.io.IOException;
import java.util.*;
import Pages.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Commons.WebDriverCommons;
import BrowserDriver.WebDriverFile;
import Utils_Framework.ExcelFileHandling;
import Utils_Framework.PropertyFileHandle;
import junit.framework.Assert;

public class PageFactortype extends WebDriverFile{
	@BeforeSuite
	public void LaunchTheBrowser() throws InterruptedException
	{
		Launch();
	}
	
	@BeforeTest
	public void LauchTheBrowserURL() throws InterruptedException
	{
		String url = PropertyFileHandle.propreaddata().getProperty("URL");
		driver.get(url);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		
	}
@SuppressWarnings("deprecation")
@Test(priority=0, dataProvider = "searchdata", dataProviderClass=DataProviderClass.class) // dataProviderClass is placed in another class so calling here
	public void Flightsearch(String Fromlocation, String Tolocation, String date) throws Exception // how much col in added in the excel that much parameter we have to give in the method 
	{
		/*
		 * Launch the Browser and enter the application url
		 * select from location
		 * select to location
		 * select date
		 * click on search
		 * wait for search result page
		 * validate search result criteria is match with the search input
		 */
	PageFactorewithpageobjectframework s = new PageFactorewithpageobjectframework(driver);
	s.clickfromlocation();
	s.selectfromlocation(Fromlocation);
	s.clicktolocation1();
	s.selectfromlocation(Tolocation);
	s.selectdate(date);
	s.clickonsearchbutton();
	searchresultpage srp = new searchresultpage(driver);
	String Searchresult = srp.waitandgetsearchtext();
	System.out.println(Searchresult);
	srp.waitForOkayGotIt();
	s.ClickOnBackButton(driver);
	Assert.assertEquals(s.getsearchresultvalue(), Searchresult);
}
@Test(priority=1, dataProvider = "searchdatawithinvalid", dataProviderClass=DataProviderClass.class)
public void Flightsearchwithinvalid(String Fromlocation, String Tolocation) throws Exception
{
	PageFactorewithpageobjectframework s = new PageFactorewithpageobjectframework(driver);
	s.clickfromlocation();
	s.selectfromlocation(Fromlocation);
	s.clicktolocation1();
	s.selectfromlocation(Tolocation);
	String actualerror = s.errormessageforesamecity();
	//s.ClickOnBackButton(driver);
	Assert.assertEquals("From & To airports cannot be the same", actualerror);
}

@AfterSuite
public void close()
{
	//driver.quit();
}



}

