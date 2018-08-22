package Scripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SocialMediaTest {

	public static void main(String[] args) throws InterruptedException {

		File pathToBinary = new File(
				"C:\\Users\\AM101_PC14\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		driver.manage().window().maximize();
		driver.get("http://205.147.102.59:9001/");
		Thread.sleep(1000);
		
		//share with friends
		System.out.println("Share with friends:\n");
		By fb=By.xpath("/html/body/footer/div/div/div[1]/p[2]/a[1]/i");
		WebElement fbw=driver.findElement(fb);
		fbw.click();
		System.out.println("Clicked Faacebook\n");
		Thread.sleep(1000);
		
		By twitter=By.xpath("/html/body/footer/div/div/div[1]/p[2]/a[2]/i");
		WebElement twitterw=driver.findElement(twitter);
		twitterw.click();
		System.out.println("Clicked Twitter\n");
		Thread.sleep(1000);
		
		
		By Linkdn=By.xpath("/html/body/footer/div/div/div[1]/p[2]/a[3]/i");
		WebElement Linkdnw=driver.findElement(Linkdn);
		Linkdnw.click();
		System.out.println("Clicked Linkedn\n");
		Thread.sleep(1000);
		
		//connect with us
		
		System.out.println("Connect with us:\n");
		By fb1=By.xpath("/html/body/footer/div/div/div[3]/a[1]/i");
		WebElement fbw1=driver.findElement(fb1);
		fbw1.click();
		System.out.println("Clicked Faacebook\n");
		Thread.sleep(1000);
		
		By twitter1=By.xpath("/html/body/footer/div/div/div[3]/a[2]/i");
		WebElement twitterw1=driver.findElement(twitter1);
		twitterw1.click();
		System.out.println("Clicked Twitter\n");
		Thread.sleep(1000);
		
		
		By Linkdn1=By.xpath("/html/body/footer/div/div/div[3]/a[3]/i");
		WebElement Linkdnw1=driver.findElement(Linkdn1);
		Linkdnw1.click();
		System.out.println("Clicked Linkedn\n");
		Thread.sleep(1000);
		
		driver.close();
	}

}
