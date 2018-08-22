package Scripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class functionLogin {

	
	
	public void functionLogin(WebDriver driver) throws InterruptedException{
		

		By login = By.xpath("//*[@id='show_login']");
		WebElement we = driver.findElement(login);
		we.click();
		Thread.sleep(500);
		By emailid = By.xpath("//*[@id='login_email']");
		WebElement we1 = driver.findElement(emailid);
		we1.sendKeys("takshil1996@gmail.com");
		
		Thread.sleep(500);
		By pass = By.xpath("//*[@id='login_password']");
		WebElement we2 = driver.findElement(pass);
		we2.sendKeys("Beast");
		
		Thread.sleep(500);
		
		By loginclick = By.xpath("//*[@id='login_submit']");
		WebElement we3 = driver.findElement(loginclick);
		we3.click();
		
	}
}
