package com.ali.pages.webelementrepository;

import org.openqa.selenium.By;

/**
 * @author Gokul
 * This interface is used a object repository 
 *
 */
public interface Master {

	By LOGO = By.xpath("//span[@class='logo-base']");
	By PROMO_AD = By.xpath("//a[@class='close-layer']");
	By SEARCH_TEXT = By.xpath("//input[@name='SearchText']");
	By SEARCH_BTN = By.xpath("//input[@class='search-button']");
	By PRODUCT_NAME = By.xpath("//a[@class='history-item product ']");
	By CATEGORY_PRODUCT_NAME = By.xpath("//a[@class=' product ']");
	By PRODUCT_PRICE = By.xpath("//span[@itemprop='price']");
	String CATEGORY_NAME = "//dt[@class='cate-name']/following::span/a[contains(text(),'%s')]";
	String SUB_CATEGORY_NAME = "//div[@class='bc-big-row-wrap']/following::h2/a[contains(text(),'%s')]";
}
