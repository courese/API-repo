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

import com.relevantcodes.extentreports.LogStatus;

import Commons.WebDriverCommons;
import BrowserDriver.WebDriverFile;
import Utils_Framework.ExcelFileHandling;
import Utils_Framework.PropertyFileHandle;
import junit.framework.Assert;

public class DDFramworkType1 extends WebDriverFile{
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
	test.log(LogStatus.INFO, "Successfully launched");
	DDFSearchpage s = new DDFSearchpage(driver);
	s.clickfromlocation();
	s.selectfromlocation(Fromlocation);
	test.log(LogStatus.INFO, "Successfully selected the from location" +Fromlocation);
	s.clicktolocation1();
	s.selectfromlocation(Tolocation);
	test.log(LogStatus.INFO, "Successfully selected the to location" +Tolocation);
	s.selectdate(date);
	test.log(LogStatus.INFO, "Successfully clicked the date" +date);
	s.clickonsearchbutton();
	test.log(LogStatus.INFO, "Successfully clicked the search button");
	searchresultpage srp = new searchresultpage(driver);
	srp.waitForOkayGotIt();
	test.log(LogStatus.INFO, "Successfully clicked the waitForOkayGotIt popup");
	String Searchresult = srp.waitandgetsearchtext();
	System.out.println(Searchresult);	
	s.ClickOnBackButton(driver);
	Assert.assertEquals(s.getsearchresultvalue(), Searchresult);
	test.log(LogStatus.PASS, "Successfully validated the searchresult");
	
}
@Test(priority=1, dataProvider = "searchdatawithinvalid", dataProviderClass=DataProviderClass.class)
public void Flightsearchwithinvalid(String Fromlocation, String Tolocation) throws Exception
{
	test.log(LogStatus.INFO, "Successfully launched");
	DDFSearchpage s = new DDFSearchpage(driver);
	s.clickfromlocation();
	s.selectfromlocation(Fromlocation);
	test.log(LogStatus.INFO, "Successfully selected the from location" +Fromlocation);
	s.clicktolocation1();
	s.selectfromlocation(Tolocation);
	test.log(LogStatus.INFO, "Successfully selected the to location" +Tolocation);
	String actualerror = s.errormessageforesamecity();
	//s.ClickOnBackButton(driver);
	Assert.assertEquals("From & To airports cannot be the same", actualerror);
	test.log(LogStatus.PASS, "Successfully validated the errormessages" +actualerror);
}

@AfterSuite
public void close()
{
	extentreportclose();
	//driver.quit();
}



}

