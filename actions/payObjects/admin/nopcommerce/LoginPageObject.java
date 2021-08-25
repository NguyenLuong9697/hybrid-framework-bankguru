package payObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.admin.nopcommerce.LoginPageUI;

public class LoginPageObject  extends BasePage{

	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void inputToEmailTextbox(String emailAdrress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver,  LoginPageUI.EMAIL_TEXTBOX, emailAdrress);
		
	}
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password);
	}
	public DashboardPageObject clickLoginButton() {
		waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardPageObject(driver);
	}
}
