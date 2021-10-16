package payObjects.saucedemo;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.saucedemo.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public ProductPageObject loginToSystem(String username, String password) {
		waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXT_BOX);
		sendKeyToElement(driver, LoginPageUI.USER_NAME_TEXT_BOX, username);
		waitForElementVisible(driver, LoginPageUI.PASS_WORD_TEXT_BOX);
		sendKeyToElement(driver, LoginPageUI.PASS_WORD_TEXT_BOX, password);
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPageObject(driver);
	}
}
