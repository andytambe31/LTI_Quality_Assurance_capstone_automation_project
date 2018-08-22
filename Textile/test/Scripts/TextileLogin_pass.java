package Scripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TextileLogin_pass {

	public static void main(String[] args) throws InterruptedException {
		File pathToBinary = new File(
				"C:\\Users\\AM101_PC14\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		driver.manage().window().maximize();
		driver.get("http://205.147.102.59:9001/");
		
		By login = By.xpath("//*[@id='show_login']");
		WebElement we = driver.findElement(login);
		we.click();
		
		By emailid = By.xpath("//*[@id='login_email']");
		WebElement we1 = driver.findElement(emailid);
		we1.sendKeys("ppe422@gmail.com");
		
		
		By pass = By.xpath("//*[@id='login_password']");
		WebElement we2 = driver.findElement(pass);
		we2.sendKeys("Gus0007");
		

		By loginclick = By.xpath("//*[@id='login_submit']");
		WebElement we3 = driver.findElement(loginclick);
		we3.click();
		
		
		
		
		
		
		//Thread.sleep(2000);
		//driver.close();
	}

}
