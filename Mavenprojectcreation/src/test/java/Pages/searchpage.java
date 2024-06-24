package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Commons.WebDriverCommons;

public class searchpage extends WebDriverCommons {
	WebDriver driver;
	public searchpage(WebDriver driver)
	{
		this.driver = driver;     //this is the consructor to define the driver value to avoid null pointer exception error in the page.
	}
	public void clickfromlocation() throws InterruptedException
	{
		Thread.sleep(5000);
		Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("//*[@for='fromCity']")));
		
		driver.findElement(By.xpath("//*[@for='fromCity']")).click();
	}


	public void clicktolocation1() throws Exception
	{
		Thread.sleep(5000);
		Explicitwaitforelementobeclickable(driver,driver.findElement(By.xpath("//*[@id='toCity']")));
		driver.findElement(By.xpath("//*[@id='toCity']")).click();
	}

	public void selectfromlocation(String Expectedlocation)
	{
Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("(//*[@id='react-autowhatever-1']//li)[last()]")));
		List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='react-autowhatever-1']//li"));
		for(int i=1;i<allElements.size();i++)
		{
			String actualLocation = driver.findElement(By.xpath("//*[@id='react-autowhatever-1']//li["+i+"]//div[contains(@class,'pushRight')]")).getText();
			if (Expectedlocation.equalsIgnoreCase(actualLocation))
			{
				driver.findElement(By.xpath("//*[@id='react-autowhatever-1']//li["+i+"]")).click();
				break;
			}
				
		}
	}

	public void selectdate(String Datetobeselected)
	{
		Explicitwaitforpresencefelement(driver, By.xpath("(//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')]"));
		
		List<WebElement> AllDates = driver.findElements(By.xpath("(//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')]"));
		for(int i=1;i<=AllDates.size();i++)
		{
			String dateIsDisabled = driver.findElement(By.xpath("((//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')])["+i+"]")).getAttribute("class");
			if(!dateIsDisabled.contains("disabled"))
			{
				String actualDate = driver.findElement(By.xpath("((//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')])["+i+"]//p")).getText();
				if (actualDate.equalsIgnoreCase(Datetobeselected))
				{
					driver.findElement(By.xpath("((//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')])["+i+"]")).click();
					break;
				}
			}
			
		}
	}
	public void clickonsearchbutton()
	{
		driver.findElement(By.xpath("//*[text()='Search']")).click();
	}

	public String errormessageforesamecity()
	{
		List<WebElement> elementexist = driver.findElements(By.xpath("//*[@data-cy='sameCityError']"));
		if (elementexist.size()>0)
		{
		Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("//*[@data-cy='sameCityError']")));
		return driver.findElement(By.xpath("//*[@data-cy='sameCityError']")).getText();
		}
		return "No Error exists";
	}

}
