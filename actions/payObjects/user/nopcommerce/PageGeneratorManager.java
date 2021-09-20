package payObjects.user.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePageObject;
	private static LoginPageObject loginPageObject;
	private static RegisterPageObject registerPageObject;
	private static MyAccountPageObject myAccountPageObject;
	private static SearchPageObject searchPageObject;
	private static OrdersPageObject ordersPageObject;
	
	private PageGeneratorManager() {
		
	}
	public static HomePageObject getHomePageObject(WebDriver driver) {
		//if(homePageObject==null) {
			homePageObject=new HomePageObject(driver);
		//}
		return homePageObject;
		//return new HomePageObject(driver);
	}
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		//if(loginPageObject==null) {
			loginPageObject=new LoginPageObject(driver);
		//}
		return loginPageObject;
		//return new LoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		//if(registerPageObject==null) {
			registerPageObject=new RegisterPageObject(driver);
		//}
		return registerPageObject;
		//return new LoginPageObject(driver);
	}
	public static MyAccountPageObject getMyAccountPageObject(WebDriver driver) {
		//if(myAccountPageObject==null) {
			myAccountPageObject=new MyAccountPageObject(driver);
		//}
		return myAccountPageObject;
		//return new RegisterPageObject(driver);
	}
	public static SearchPageObject getSearchPageObject(WebDriver driver) {
		//if(searchPageObject==null) {
			searchPageObject=new SearchPageObject(driver);
		//}
		return searchPageObject;
		//return new RegisterPageObject(driver);
	}
	public static OrdersPageObject getOrdersPageObject(WebDriver driver) {
		//if(ordersPageObject==null) {
			ordersPageObject=new OrdersPageObject(driver);
		//}
		return ordersPageObject;
		//return new RegisterPageObject(driver);
	}
	
}
