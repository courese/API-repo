package Testcases;

import java.util.*;
import Pages.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import BrowserDriver.WebDriverFile;
import Utils_Framework.PropertyFileHandle;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class POMFramework extends WebDriverFile{
	@BeforeSuite
	public void LaunchTheBrowser() throws InterruptedException
	{
		Launch();
	}
	
	@BeforeTest
	public void LauchTheBrowserURL()
	{
		String url = PropertyFileHandle.propreaddata().getProperty("URL");
		driver.get(url);
		
	}
@Test(priority=0)
	public void Flightsearch() throws Exception
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
	searchpage s = new searchpage(driver);
	s.clickfromlocation();
	s.selectfromlocation("BOM");
	s.clicktolocation1();
	s.selectfromlocation("MAA");
	s.selectdate("30");
	s.clickonsearchbutton();
	
	
	searchresultpage srp = new searchresultpage(driver);
	String Searchresult = srp.waitandgetsearchtext();
	System.out.println(Searchresult);
	srp.waitForOkayGotIt();
	Assert.assertEquals("Flights from Mumbai to Chennai", Searchresult);
	}

@Test(priority=1)
public void Flightsearchwithinvalid() throws Exception
{
	searchpage s = new searchpage(driver);
	s.ClickOnBackButton(driver);
	s.clickfromlocation();
	s.selectfromlocation("MAA");
	s.clicktolocation1();
	s.selectfromlocation("MAA");
	String actualerror = s.errormessageforesamecity();
	Assert.assertEquals("From & To airports cannot be the same", actualerror);
}
@Test(priority=2)
public void validatingtheerrorwithcorrection() throws Exception
{
	searchpage s = new searchpage(driver);
	s.clickfromlocation();
	s.selectfromlocation("BOM");
	String actualerror = s.errormessageforesamecity();
	Assert.assertEquals("No Error exists", actualerror);
}

@AfterSuite
public void close()
{
	//driver.quit();
}

}

