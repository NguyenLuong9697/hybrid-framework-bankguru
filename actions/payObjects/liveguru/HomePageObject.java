package payObjects.liveguru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.liveguru.HomePageUI;


public class HomePageObject extends BasePage {
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void clickMyAccountOnFooter() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_FOOTER_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_FOOTER_LINK);
	}

}
