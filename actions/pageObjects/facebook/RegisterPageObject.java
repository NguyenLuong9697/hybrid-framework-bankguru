package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.facebook.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isEmailTextboxDisplayed() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);		
		return isElementDisplay(driver, RegisterPageUI.EMAIL_TEXTBOX);
	}
	public boolean isConfirmEmailUnDisplay() {
		// TODO Auto-generated method stub
		waitForElementInvisible(driver,RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementDisplay(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}
	public void inputEmailTextbox(String emailAddress) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}
	public boolean isLoginButtonDisplay() {
		// TODO Auto-generated method stub
		//waitForElementInvisible(driver, RegisterPageUI.LOGIN_BUTTON);
		
		return isElementDisplay(driver, RegisterPageUI.LOGIN_BUTTON);
	}
	public boolean isLoginButtonUnDisplay() {
		// TODO Auto-generated method stub
		waitForElementInvisible(driver, RegisterPageUI.LOGIN_BUTTON);
		return isElementUndisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
		
	}
	public boolean isConfirmEmailDisplay() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementDisplay(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}
}
