package payObjects.saucedemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import payUIs.saucedemo.ProductPageUI;

public class ProductPageObject extends BasePage {

	private WebDriver driver;
	public ProductPageObject(WebDriver driver) {
		
		this.driver=driver;
	}
	public void selectItemInSortDropdown(String valueItem) {
		waitForElementClickable(driver, ProductPageUI.SORT_DROP_DOWN);
		selectItemInDefaultDropdownByText(driver, ProductPageUI.SORT_DROP_DOWN, valueItem);
		
	}
	public String getSeletedValueInSortDropdown() {
		
		waitForElementVisible(driver, ProductPageUI.SORT_DROP_DOWN);
		return getSelectedItemInDefaultDropdown(driver, ProductPageUI.SORT_DROP_DOWN);
	}
	public boolean isProductNameSortAscending() {
		List<String> listProductNameText = new ArrayList<String>();
		List<WebElement> products= getListWebElements(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		for (WebElement webElement : products) {
			listProductNameText.add(webElement.getText().trim());
		}
		
		List<String> listProductNameTextClone= new ArrayList<String>(listProductNameText);
		Collections.sort(listProductNameTextClone);			
		return listProductNameText.equals(listProductNameTextClone);
	}
	public boolean isProductNameSortDescending() {
		// TODO Auto-generated method stub
		List<String> listProductNameText = new ArrayList<String>();
		List<WebElement> products= getListWebElements(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		for (WebElement webElement : products) {
			listProductNameText.add(webElement.getText().trim());
		}		
		List<String> listProductNameTextClone= new ArrayList<String>(listProductNameText);
		Collections.sort(listProductNameTextClone);	
		Collections.reverse(listProductNameTextClone);
		return listProductNameText.equals(listProductNameTextClone);
	}
	public boolean isProductPriceSortAscending() {
		List<Float> listProductPriceText = new ArrayList<Float>();
		List<WebElement> products= getListWebElements(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		for (WebElement webElement : products) {
			listProductPriceText.add(Float.parseFloat(webElement.getText().trim().replace("$","")));
			
		}
		
		List<Float> listProductPriceTextClone= new ArrayList<Float>(listProductPriceText);
		Collections.sort(listProductPriceTextClone);			
		return listProductPriceText.equals(listProductPriceTextClone);
	}
	public boolean isProductPriceSortDescending() {
		List<Float> listProductPriceText = new ArrayList<Float>();
		List<WebElement> products= getListWebElements(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		for (WebElement webElement : products) {
			listProductPriceText.add(Float.parseFloat(webElement.getText().trim().replace("$","")));
			
		}
		
		List<Float> listProductPriceTextClone= new ArrayList<Float>(listProductPriceText);
		Collections.sort(listProductPriceTextClone);	
		Collections.reverse(listProductPriceTextClone);
		return listProductPriceText.equals(listProductPriceTextClone);
	}
}
