package payObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePageObject;
	private static LoginPageObject loginPageObject;
	private static RegisterPageObject registerPageObject;
	private PageGeneratorManager() {
		
	}
	public static HomePageObject getHomePageObject(WebDriver driver) {
		if(homePageObject==null) {
			homePageObject=new HomePageObject(driver);
		}
		return homePageObject;
		//return new HomePageObject(driver);
	}
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		if(loginPageObject==null) {
			loginPageObject=new LoginPageObject(driver);
		}
		return loginPageObject;
		//return new LoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		if(registerPageObject==null) {
			registerPageObject=new RegisterPageObject(driver);
		}
		return registerPageObject;
		//return new RegisterPageObject(driver);
	}
}
