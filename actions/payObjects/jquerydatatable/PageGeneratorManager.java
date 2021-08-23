package payObjects.jquerydatatable;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	private static HomePageObject homePageObject;
	private PageGeneratorManager() {
		
	}
	public static HomePageObject getHomePageObject(WebDriver driver) {
		if(homePageObject==null) {
			homePageObject=new HomePageObject(driver);
		}
		return homePageObject;
	}
	
}
