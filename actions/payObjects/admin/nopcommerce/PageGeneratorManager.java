package payObjects.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import payObjects.user.nopcommerce.HomePageObject;

public class PageGeneratorManager {
	private static LoginPageObject loginPage;
	private static DashboardPageObject dashboardPage;
	private static ProductPageObject productPage;
	private static ProductDetailPageObject productDetailPage;
	private PageGeneratorManager() {
		
	}
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		if(loginPage==null) {
			loginPage=new LoginPageObject(driver);
		}
		return loginPage;		
	}
	public static DashboardPageObject getDashboardPageObject(WebDriver driver) {
		if(dashboardPage==null) {
			dashboardPage=new DashboardPageObject(driver);
		}
		return dashboardPage;		
	}
	public static ProductPageObject getProductPageObject(WebDriver driver) {
		if(productPage==null) {
			productPage=new ProductPageObject(driver);
		}
		return productPage;		
	}
	
	public static ProductDetailPageObject getProductDetailPageObject(WebDriver driver) {
		if(productDetailPage==null) {
			productDetailPage=new ProductDetailPageObject(driver);
		}
		return productDetailPage;		
	}
}
