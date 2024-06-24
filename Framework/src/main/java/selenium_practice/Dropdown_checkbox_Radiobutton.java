package selenium_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Dropdown_checkbox_Radiobutton {
	public void radiobutton() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize(); 
	driver.get("https://leafground.com/dashboard.xhtml");
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"menuform:j_idt40\"]//ul//li[contains(@id,'menuform:m_radio')]"));
	driver.findElement(By.xpath("//*[@id=\"menuform:j_idt40\"]//ul//li[contains(@id,'menuform:m_radio')]")).click();
	
	}
	public static void main(String[] args) {
		Dropdown_checkbox_Radiobutton s = new Dropdown_checkbox_Radiobutton();
		s.radiobutton();
	}
}
