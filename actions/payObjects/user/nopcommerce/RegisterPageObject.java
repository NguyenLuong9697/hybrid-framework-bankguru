package payObjects.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickToMaleRadioButton() {
		// TODO Auto-generated method stub
		// wait cho Radiobutton co the click dc
		waitForElementVisible(driver, RegisterPageUI.RADIO_BUTTON_MALE);
		// click vao Radio male
		clickToElement(driver, RegisterPageUI.RADIO_BUTTON_MALE);
	}

	public void enterToFirstName(String firstName) {
		// TODO Auto-generated method stub
		// wait cho Fist Name text box dc hien thi
		waitForElementVisible(driver, RegisterPageUI.TEXT_BOX_FIRSTNAME);
		// enter FirtName
		sendKeyToElement(driver, RegisterPageUI.TEXT_BOX_FIRSTNAME, firstName);

	}

	public void enterToLastName(String lastName) {
		// TODO Auto-generated method stub
		// wait cho Last Name text box dc hien thi
		waitForElementVisible(driver, RegisterPageUI.TEXT_BOX_LASTNAME);
		// enter Last Name
		sendKeyToElement(driver, RegisterPageUI.TEXT_BOX_LASTNAME, lastName);

	}

	public void enterToEmail(String email) {
		// TODO Auto-generated method stub
		// wait cho Email text box dc hien thi
		waitForElementVisible(driver, RegisterPageUI.TEXT_BOX_EMAIL);
		// enter Email
		sendKeyToElement(driver, RegisterPageUI.TEXT_BOX_EMAIL, email);
	}

	public void enterToPassWord(String passWord) {
		// TODO Auto-generated method stub
		// wait cho pass word text box dc hien thi
		waitForElementVisible(driver, RegisterPageUI.TEXT_BOX_PASSWORD);
		// enter Pass word
		sendKeyToElement(driver, RegisterPageUI.TEXT_BOX_PASSWORD, passWord);
	}

	public void enterToConfirmPassWord(String confirmPassword) {
		// TODO Auto-generated method stub
		// wait cho Confirm password text box dc hien thi
		waitForElementVisible(driver, RegisterPageUI.TEXT_BOX_CONFIRM_PASSWORD);
		// enter Confirm password
		sendKeyToElement(driver, RegisterPageUI.TEXT_BOX_CONFIRM_PASSWORD, confirmPassword);
	}

	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		//wait cho button co the click
		waitForElementClickable(driver, RegisterPageUI.BUTTON_REGISTER);
		//click vao button Register
		clickToElement(driver, RegisterPageUI.BUTTON_REGISTER);

	}

	public boolean isRegisterMessageSuccessDisplay() {
		// TODO Auto-generated method stub
		//wait cho message register sucess dc hien thi
		waitForElementVisible(driver, RegisterPageUI.MESSAGE_REGISTER_SUCCESS);
		return isElementDisplay(driver, RegisterPageUI.MESSAGE_REGISTER_SUCCESS);
		
	}

	public HomePageObject clickToLogoutLink() {
		// TODO Auto-generated method stub
		//wait cho Logout link dc hien thi
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		//click Logout
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		//return new HomePageObject(driver);
		if(driver.toString().contains("chrome")|| driver.toString().contains("edge")) {
			sleepInSecond(3);
		}
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public String getSuccessMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.MESSAGE_REGISTER);
		return getTextElement(driver, RegisterPageUI.MESSAGE_REGISTER);
		//return false;
	}

}
