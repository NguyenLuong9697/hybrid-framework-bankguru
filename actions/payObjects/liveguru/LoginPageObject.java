package payObjects.liveguru;



import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.liveguru.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmailAdress(String emailAddress) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX,emailAddress);
		
	}

	public void enterPassword(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password);
	}

	public void clickLoginButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
	}

	public String getEmptyEmailErrorMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		
	}

	public String getEmptyPasswordErrorMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
	}

	public String getInvalidEmailErrorMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
	}

	public String getInvalidPasswordErrorMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
	}

	public String getIncorrectPasswordErrorMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.INCORRECT_PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.INCORRECT_PASSWORD_ERROR_MESSAGE);
	}

	public String getIncorrectEmailErrorMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.INCORRECT_EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.INCORRECT_PASSWORD_ERROR_MESSAGE);
	}
	
}
