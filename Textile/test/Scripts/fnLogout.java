package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fnLogout {

	public void fnLogout(WebDriver driver) throws InterruptedException {

		Thread.sleep(500);
		
		By profile=By.xpath("//*[@id='cssmenu']/ul/li/a/span");
		WebElement profilew=driver.findElement(profile);
		profilew.click();
		
		By logout=By.xpath("//*[@id='cssmenu']/ul/li/ul/li[3]/a");
		WebElement logoutw=driver.findElement(logout);
		logoutw.click();
	}

}
