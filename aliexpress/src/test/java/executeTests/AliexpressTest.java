package executeTests;

import org.testng.annotations.Test;

import com.ali.framework.BrowserTypes;
import com.ali.framework.DriverFactory;
import com.ali.framework.ExcelFactory;
import com.ali.pages.webpagerepository.MasterPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;


/**
 * @author Gokul
 * this Class is used to execute Test cases in www.aliexpress.com
 *
 */
public class AliexpressTest {
	
	public WebDriver driver;
	DriverFactory driverFact = new DriverFactory();
	String sheetName = driverFact.getProperty("TestDataSheetName");

  @BeforeTest
  public void beforeTest() {
	  driverFact.initializeDriver();
	  driver = driverFact.getDriver();
  }
  
  @Test(groups="Smoke Test")
  public void searchProductByAllCategory(final ITestContext testContext) {
	  MasterPage mp = new MasterPage(driver);
	  mp.launchapplication();
	  mp.searchByProductName("TC_001", "Product");
	  mp.getProductResults();
  }
  
  @Test(groups="Regression")
  public void searchProductByCategory(final ITestContext testContext) {
	  MasterPage mp = new MasterPage(driver);
	  mp.launchapplication();
	  mp.searchByCategoryName("TC_002", "Category", "Product");
	  mp.getProductResults();
  }

  @AfterTest
  public void afterTest() {
	  driverFact.quitDriver();
  }

}
