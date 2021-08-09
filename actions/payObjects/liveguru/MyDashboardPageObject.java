package payObjects.liveguru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.liveguru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;
	public MyDashboardPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	
	public boolean isTitleMyDashboardDisplay() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyDashboardPageUI.MY_DASH_BOARD_PAGE);
		return isElementDisplay(driver, MyDashboardPageUI.MY_DASH_BOARD_PAGE);
	}

}
