package payObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.admin.nopcommerce.DashboardPageUI;
import payUIs.admin.nopcommerce.ProductPageUI;

public class ProductPageObject  extends BasePage{

	private WebDriver driver;
	public ProductPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void clickToExpandSearchPanel() {
		waitForElementClickable(driver,ProductPageUI.ICON_EXPAND_SEARCH_PANEL);
		String status= getAttributeElement(driver, ProductPageUI.ICON_EXPAND_SEARCH_PANEL,"class");
		if(status.contains("fa-angle-down")) {
			clickToElement(driver, ProductPageUI.ICON_EXPAND_SEARCH_PANEL);
		}
		
	}
	
	public void inputToProductNameTextbox(String productName) {
		waitForElementVisible(driver,ProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendKeyToElement(driver,ProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
		
	}
	
	public void clickSearchButton() {
		waitForElementClickable(driver, ProductPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductPageUI.SEARCH_BUTTON);
		
	}
	public ProductDetailPageObject clickEditIconByProductName(String productName) {
		waitForElementClickable(driver,ProductPageUI.EDIT_ICON_BY_PRODUCT_NAME,productName);
		clickToElement(driver,ProductPageUI.EDIT_ICON_BY_PRODUCT_NAME,productName);
		return PageGeneratorManager.getProductDetailPageObject(driver);
	}
	public boolean isSuccessMessageDisplayed(String message) {
		waitForElementVisible(driver,ProductPageUI.SUCCESS_MESSAGE,message);
		return isElementDisplay(driver,ProductPageUI.SUCCESS_MESSAGE,message);
	}
	
	public boolean isImageUpdatedSuccessByProductName(String productName, String imageProduct) {
		imageProduct=imageProduct.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductPageUI.IMAGE_PRODUCT_BY_PRODUCT_NAME, productName,imageProduct);
		return isElementDisplay(driver, ProductPageUI.IMAGE_PRODUCT_BY_PRODUCT_NAME, productName,imageProduct);
	}
}
