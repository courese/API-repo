package selenium_practice;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class Naukri_login {
	public void test(String[] Enteredvalue)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class=\"nI-gNb-log-reg\"]//a[@id=\"login_Layer\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//div[@class=\"form-row\"]//input[contains(@placeholder,'Username')]")).sendKeys("lakshmirajamohan21@gmail.com");
		driver.findElement(By.xpath("//div[@class=\"form-row\"]//input[contains(@placeholder,'password')]")).sendKeys("Lakshmi@2109");
		driver.findElement(By.xpath("//*[@class=\"login-layer\"]//div[6]")).click();
		driver.findElement(By.xpath("//*[@class=\"reco-head\"]//a//span[contains(text(), 'View all')]")).click();
		List<WebElement> AllValues = driver.findElements(By.xpath("//article[contains(@class, 'jobTuple')]"));		
		for(int i =0;i<AllValues.size();i++) {
			String values = AllValues.get(i).getAttribute("data-job-id");
			for(String enteredvalue : Enteredvalue) {
			if (values.equalsIgnoreCase(enteredvalue))
					{
				driver.findElement(By.xpath("//i[contains(@class,'naukicon-ot-checkbox')]")).click();
				break;
					}
			driver.findElement(By.xpath("//*[@class=\"recommended-jobs-page\"]//button[contains(text(), 'Apply')]")).click();
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='_ni5zs494zChatbotContainer']")));
			
			WebElement chatbotMessage = driver.findElement(By.xpath("//div[@id=\"_zf4e7fshzChatbotContainer\"]//li[3]//span"));
            String messageText = chatbotMessage.getText();
            if (messageText.equalsIgnoreCase("Are you comfortable for C2H")) {
                WebElement userInputBox = driver.findElement(By.xpath("//*[@id='userInput__d2j2obikeInputBox']"));
                userInputBox.sendKeys("Yes");
            }

            break;
		}
		}
		
	}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	Naukri_login m = new Naukri_login();
	String[] test={"300424007891","300424005736"};
	m.test(test);

}
}




