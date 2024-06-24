package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.WebDriverCommons;

public class PageFactorewithpageobjectframework extends WebDriverCommons {
	@FindBy(xpath = "//*[@for='fromCity']")
	WebElement fromCity;
	@FindBy(xpath = "//*[@id='toCity']")
	WebElement toCity;
	
	WebDriver driver;
	
	public PageFactorewithpageobjectframework(WebDriver driver)
	{
		this.driver = driver;     //this is the consructor to define the driver value to avoid null pointer exception error in the page.
		PageFactory.initElements(driver, this); //doubt
	}
	public void clickfromlocation() throws InterruptedException
	{
		Thread.sleep(5000);
		//Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("//*[@for='fromCity']")));
		Explicitwaitforelementobeclickable(driver, fromCity);
		//driver.findElement(By.xpath("//*[@for='fromCity']")).click();
		fromCity.click();
	}
	public void clicktolocation1() throws Exception
	{
		Thread.sleep(5000);
		//Explicitwaitforelementobeclickable(driver,driver.findElement(By.xpath("//*[@id='toCity']")));
		Explicitwaitforelementobeclickable(driver,toCity);
		//driver.findElement(By.xpath("//*[@id='toCity']")).click();
		toCity.click();
	}

	public void selectfromlocation(String Expectedlocation)
	{
		String basePath = "//*[@id='react-autowhatever-1']//li";
		//Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("(//*[@id='react-autowhatever-1']//li)[last()]")));
		//List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='react-autowhatever-1']//li"));
		Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("("+basePath+")[last()]")));
		List<WebElement> allElements = driver.findElements(By.xpath(basePath));

		for(int i=1;i<allElements.size();i++)
		{
			String actualLocation = driver.findElement(By.xpath(basePath+"["+i+"]//div[contains(@class,'pushRight')]")).getText();
			if (Expectedlocation.equalsIgnoreCase(actualLocation))
			{
				driver.findElement(By.xpath(basePath+"["+i+"]")).click();
				break;
			}
				
		}
	}

	public void selectdate(String Datetobeselected)
	{
		//String basePath = "//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')]";
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
	public String GetFromlocation()
	{
		Explicitwaitforpresencefelement(driver, By.xpath("//*[@id='fromCity']"));
		return driver.findElement(By.xpath("//*[@id='fromCity']")).getAttribute("value");
	}
	public String GetTolocation()
	{
		Explicitwaitforpresencefelement(driver, By.xpath("//*[@id='toCity']"));
		return driver.findElement(By.xpath("//*[@id='toCity']")).getAttribute("value");
	}
	public String getsearchresultvalue()
	{
		String  finalResult = "Flights from "+GetFromlocation()+" to "+GetTolocation();
		return finalResult;
	}
	
	public String getsearchresultvaluewithinvalid() {
		// TODO Auto-generated method stub
		String  finalResult = "Flights from "+GetFromlocation()+" to "+GetTolocation();
		return finalResult;
	}
}
