package com.ali.pages.webpagerepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.ali.commons.ReusableLibrary;
import com.ali.framework.BrowserTypes;
import com.ali.framework.DriverFactory;
import com.ali.framework.ExcelFactory;
import com.ali.pages.webelementrepository.Master;

/**
 * @author Gokul
 * This class is used as main page functionality 
 *
 */
public class MasterPage extends ReusableLibrary implements Master{

	public MasterPage(WebDriver driver) {
		super(driver);
	}
	DriverFactory driverProperty = new DriverFactory();
	ExcelFactory excelSheet = new ExcelFactory();
	String sheetName = driverProperty.getProperty("TestCaseData");
	
	
	public void initializeExcel(String sheetName)
	{
		excelSheet.loadExcelsheet(sheetName);	
		  
	}
	public void launchapplication()
	{
		String url = driverProperty.getProperty("ApplicationUrl");
		getApplication(url);
		if(IsObjectPresent(PROMO_AD))
		{
			clickElement(PROMO_AD, "Prmo Ad");
		}
		if(IsObjectPresent(LOGO))
		{
			updateTestLog(true,"Clear Trip Page Loaded Successfully");
		}
	}
	
	public void searchByProductName(String testId, String product)
	{
		initializeExcel("TestCaseData");
		String productName = excelSheet.getData(testId, sheetName, product);
		if(IsObjectPresent(SEARCH_TEXT));
		{
			enterText(SEARCH_TEXT,productName);
			clickElement(SEARCH_BTN, "Search Button");
			updateTestLog(true,"Product Search is Successfull");
		}
	}
	
	public void searchByCategoryName(String testId, String category, String product)
	{
		initializeExcel("TestCaseData");
		String categoryName = excelSheet.getData(testId, sheetName, category);
		String productName = excelSheet.getData(testId, sheetName, product);
		clickElement(By.xpath(String.format(CATEGORY_NAME,categoryName)),"Category Name");
		clickElement(By.xpath(String.format(SUB_CATEGORY_NAME,productName)),"Product Name");
		waitForWindowAndSwitch(productName);
	}
	public void getProductResults()
	{
		
		By strobj = null;
		if(IsObjectPresent(PRODUCT_NAME))
		{
			strobj = PRODUCT_NAME;
		} else
		{
			strobj = CATEGORY_PRODUCT_NAME;
		}
		   List<String> productName = getTextValues(strobj);
		   List<String> productPrice = getTextValues(PRODUCT_PRICE);
		   int count=0;
	        for (String strProductName : productName){	        	
	    		Reporter.log("Prodct Name: \""+strProductName+"\" Product Price: "+productPrice.get(count));
	         }
		}
}
