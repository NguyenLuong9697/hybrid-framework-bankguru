package payFactorys.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import common.BasePageFactory;
import payUIs.user.nopcommerce.HomePageUI;

public class HomePageFactory extends BasePageFactory {
	private WebDriver driver;
	@FindBy(how = How.ID,using="nivo-slider")
	//@FindBy(id="nivo-slider")
	WebElement homePageSlider;
	
	@FindBy(how = How.CLASS_NAME,using="ico-register")
	//@FindBy(className ="ico-register")
	WebElement registerLink;
	
	@FindBy(how = How.CLASS_NAME,using="ico-login")
	WebElement loginLink;
	public HomePageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public boolean isHomeSliderDisplayed() {
		// TODO Auto-generated method stub
		//wait cho home slider hien thi
		waitForElementVisible(driver, homePageSlider);
		return  isElementDisplay(driver, homePageSlider);
		
		
	}

	public void clickToRegisterLink() {
		// TODO Auto-generated method stub
		//wait cho RegisterLink dc clickable
		waitForElementClickable(driver,registerLink);
		
		//click vao Register Link
		clickToElement(driver, registerLink);
		
	}

	public void clickToLoginLink() {
		// TODO Auto-generated method stub
		
		//wait cho Login Link dc clickable
		waitForElementClickable(driver, loginLink);
		//click vao Login Link
		clickToElement(driver,loginLink);
	}

}
