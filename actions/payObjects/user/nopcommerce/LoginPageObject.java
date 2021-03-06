package payObjects.user.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.nopcommerce.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void enterToEmail(String emailAddress) {
		// TODO Auto-generated method stub
		//wait Email textbox dc visible
		waitForElementVisible(driver, LoginPageUI.TEXTBOX_EMAIL);
		//send key vao email text box
		sendKeyToElement(driver, LoginPageUI.TEXTBOX_EMAIL,emailAddress );
	}

	public void enterToPassword(String passWord) {
		// TODO Auto-generated method stub
		// wait Email textbox dc visible
		waitForElementVisible(driver, LoginPageUI.TEXTBOX_PASSWORD);
		// send key vao email text box
		sendKeyToElement(driver, LoginPageUI.TEXTBOX_PASSWORD, passWord);
	}

	public HomePageObject clickToLoginButton() {
		// TODO Auto-generated method stub
		// wait ccho Login Button co the click dc
		waitForElementClickable(driver, LoginPageUI.BUTTON_LOGIN);
		// click vao Login
		clickToElement(driver, LoginPageUI.BUTTON_LOGIN);
		//return new HomePageObject(driver);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public HomePageObject openHomePage() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.HOME_PAGE_ICON);
		clickToElement(driver, LoginPageUI.HOME_PAGE_ICON);
		return PageGeneratorManager.getHomePageObject(driver);
		
	}

}
