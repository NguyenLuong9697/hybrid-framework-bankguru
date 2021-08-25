package payObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.admin.nopcommerce.DashboardPageUI;

public class DashboardPageObject  extends BasePage{

	private WebDriver driver;
	public DashboardPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
}
