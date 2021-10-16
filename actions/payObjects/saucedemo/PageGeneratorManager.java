package payObjects.saucedemo;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static ProductPageObject productPageObject;
	private static LoginPageObject loginPageObject;
	
	private PageGeneratorManager() {
		
	}
	public static ProductPageObject getProductPageObject(WebDriver driver) {
		//if(homePageObject==null) {
		productPageObject=new ProductPageObject(driver);
		//}
		return productPageObject;
		//return new HomePageObject(driver);
	}
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		//if(loginPageObject==null) {
			loginPageObject=new LoginPageObject(driver);
		//}
		return loginPageObject;
		//return new LoginPageObject(driver);
	}
	
}
