package payObjects.admin.nopcommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import common.GlobalConstants;
import payUIs.admin.nopcommerce.ProductDetailPageUI;

public class ProductDetailPageObject  extends BasePage{

	private WebDriver driver;
	public ProductDetailPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void clickToExpandPanelByCardName(String cardName) {
		// TODO Auto-generated method stub
		//1 get tag i attribute
		//2 not contains(fa-plus)-> k lam gi ngc lai
		// 3 click
		waitForElementClickable(driver,ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME ,cardName);
		String status=getAttributeElement(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, "class", cardName);
		if(status.contains("fa-plus")) {
			clickToElement(driver,ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME ,cardName);
		}
	}
	public void uploadFictureByFileName(String... params) {		
		String filePath=GlobalConstants.UPLOAD_FOLDER_PATH;
		String fullfileName="" ;
		for (String fileName : params) {
			fullfileName= fullfileName+filePath+fileName+"\n";
		}
		fullfileName=fullfileName.trim();
		getWebElement(driver,ProductDetailPageUI.UPLOAD_FILE_BUTTON).sendKeys(fullfileName);
		
	}
	public boolean isPictureUploadedSuccessByFileName(String imageName) {
		imageName=imageName.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_IMAGE_BY_NAME, imageName);
		return isElementDisplay(driver, ProductDetailPageUI.PRODUCT_IMAGE_BY_NAME, imageName);
		
	}
	public void inputAltTextbox(String imgAlt) {
		waitForElementVisible(driver, ProductDetailPageUI.ALT_TEXTBOX);
		sendKeyToElement(driver, ProductDetailPageUI.ALT_TEXTBOX, imgAlt);
	}
	public void inputTitleTextbox(String imgTitle) {
		waitForElementVisible(driver, ProductDetailPageUI.TITLE_TEXTBOX);
		sendKeyToElement(driver, ProductDetailPageUI.TITLE_TEXTBOX, imgTitle);
	}
	
	public void clickAddProductPictureButton() {
		waitForElementClickable(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		
		
	}
	public boolean isPictureImageDisplayed(String productName, String imgDisplayOrder, String imgAlt, String imgTitle) {
		productName=productName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductDetailPageUI.PICTURE_TABLE_INFO,productName,imgDisplayOrder, imgAlt,imgTitle);
		return isElementDisplay(driver, ProductDetailPageUI.PICTURE_TABLE_INFO,productName,imgDisplayOrder, imgAlt,imgTitle);
		
	}
	public ProductPageObject clickSaveButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, ProductDetailPageUI.SAVE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductPageObject(driver);
	}
	
	public boolean isMessageDisplayedInEmptyTable(String cardName,String messageInEmptyTable) {
		waitForElementVisible(driver,ProductDetailPageUI.MESSAGE_IN_EMPTY_TABLE,cardName, messageInEmptyTable);
		return isElementDisplay(driver,ProductDetailPageUI.MESSAGE_IN_EMPTY_TABLE,cardName, messageInEmptyTable);
		
	}
	public void clickDeleteImageInTableByCardName(String cardName) {
	
		List<WebElement> listElement=getListWebElements(driver, ProductDetailPageUI.DELETE_IMAGE_PRODUCT_IN_TABLE_BY_CARDNAME, cardName);
		waitForAllElementsVisible(driver, ProductDetailPageUI.DELETE_IMAGE_PRODUCT_IN_TABLE_BY_CARDNAME, cardName);
		
		for (WebElement webElement : listElement) {
			waitForElementClickable(driver, webElement);
			webElement.click();
			acceptAlert(driver);
			isJQueryLoadSuccess(driver);
		}
	}
	public String clickToUpDownInDisplayOrder(String cardName, String action) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, ProductDetailPageUI.UP_DOWN_VALUE_BUTTON_BY_CARD_NAME,cardName,action);
		clickToElement(driver, ProductDetailPageUI.UP_DOWN_VALUE_BUTTON_BY_CARD_NAME,cardName,action);
		sleepInSecond(2);
		return getAttributeElement(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX, "aria-valuenow");
	}
}
