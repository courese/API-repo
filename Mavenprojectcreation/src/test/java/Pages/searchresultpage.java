package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Commons.WebDriverCommons;

public class searchresultpage extends WebDriverCommons {
	WebDriver driver;
	public searchresultpage(WebDriver driver)
	{
		this.driver = driver;     //this is the consructor to define the driver value to avoid null pointer exception error in the page.
	}
	public String waitandgetsearchtext()
	{
		Explicitwaitforpresencefelement(driver,By.xpath("//*[contains(@class,'journey-title')]//span"));
		String actualresulttext = driver.findElement(By.xpath("//*[contains(@class,'journey-title')]//span")).getText();
		return actualresulttext;
	}
	public void waitForOkayGotIt() throws InterruptedException
	{
		Explicitwaitforpresencefelement(driver, By.xpath("(//div[@class='overlay']//span)[1]"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='overlay']//span)[1]")).click();
	}

}
