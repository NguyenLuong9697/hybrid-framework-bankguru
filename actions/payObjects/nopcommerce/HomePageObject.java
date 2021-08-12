package payObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.nopcommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public boolean isHomeSliderDisplayed() {
		// TODO Auto-generated method stub
		//wait cho home slider hien thi
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isElementDisplay(driver, HomePageUI.HOME_PAGE_SLIDER);
		
	}

	public RegisterPageObject clickToRegisterLink() {
		// TODO Auto-generated method stub
		//wait cho RegisterLink dc clickable
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		//click vao Register Link
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		//return new RegisterPageObject(driver);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginLink() {
		// TODO Auto-generated method stub
		
		//wait cho Login Link dc clickable
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		//click vao Login Link
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		//return new LoginPageObject(driver);
		return PageGeneratorManager.getLoginPageObject(driver);
	}

}
