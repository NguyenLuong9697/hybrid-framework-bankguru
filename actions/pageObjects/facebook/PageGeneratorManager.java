package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import payObjects.admin.nopcommerce.LoginPageObject;

public class PageGeneratorManager {

	public static RegisterPageObject registerPage;
	private PageGeneratorManager() {
		
	}
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		if(registerPage==null) {
			registerPage=new RegisterPageObject(driver);
		}
		return registerPage;		
	}
}
