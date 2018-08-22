package Scripts;

import java.io.File;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class AddProductSupplierFramework {
	public static WebDriver driver;
	public WebElement wannabeSelect;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(500);
	}

	@Test(dataProvider = "dp")
	public void f(String mainCategory,String subCategory,String color, String cottonType, String countryOfOrgin,
			String cottonFibre, String quality, String application,
			String spinning, String selectCount,String extraCount,String csp,String imperfection,
			String actualWeightPerBag,String conesPerBag,String coneWeight,
			String 	ex_MillPrice,String gst,String exDepotPrice,String depotName, 
			String 	minimumOrderQuantity,String maximumOrderQuantity, 
			String 	deliveryPeriod,String inStock) throws InterruptedException {
		
		
		driver.get("http://205.147.102.59:9001/");
		
		Thread.sleep(1000);
		
		functionLogin fn = new functionLogin();
		fn.functionLogin(driver);
		
		By profile=By.xpath("//*[@id='cssmenu']/ul/li/a/span");
		WebElement profilew=driver.findElement(profile);
		profilew.click();
		
		By products = By.xpath("//*[@id='cssmenu']/ul/li/ul/li[2]/a/span");
		WebElement productsw=driver.findElement(products);
		productsw.click();
		
		Thread.sleep(1000);
		
		By addproduct = By.xpath("//*[@id='btnAdd']/i");
		WebElement addproductw=driver.findElement(addproduct);
		addproductw.click();
		
		By search = By.xpath("//*[@id='category_chosen']/a/div/b");
		WebElement searchw=driver.findElement(search);
		searchw.click();
		
		Thread.sleep(5000);
		
		search = By.xpath("//*[@id='category_chosen']/a/div/b");
		driver.findElement(search).click();
		driver.findElement(By.xpath("//*[@id='category_chosen']/div/div/input")).sendKeys(mainCategory+Keys.ENTER);
		
		Thread.sleep(1000);
		
		search = By.xpath("//*[@id='subcategory_chosen']/a");
		driver.findElement(search).click();
		driver.findElement(By.xpath("//*[@id='subcategory_chosen']/div/div/input")).sendKeys(subCategory+Keys.ENTER);
		
		Thread.sleep(2000);
		
		if(color.equals("Raw White"))
		{
			driver.findElement(By.xpath("//*[@id='show_color']/div[1]/label")).click();
		}
		
		Thread.sleep(5000);
	}

	@DataProvider
	public Object[][] dp() {
		Object[][] retObjArr = getTableArray(
				"test\\resources\\data\\LiveTextileFramework.xls", "Sheet1",
				"delimiter");
		return (retObjArr);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String[][] getTableArray(String xlFilePath, String sheetName,
			String tableName) {
		String[][] tabArray = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);

			int startRow, startCol, endRow, endCol, ci, cj;

			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1,
					startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();

			System.out.println("startRow=" + startRow + ", endRow=" + endRow
					+ ", " + "startCol=" + startCol + ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;

			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			System.out.println("error in getTableArray()");

		}

		return (tabArray);
	}

}
