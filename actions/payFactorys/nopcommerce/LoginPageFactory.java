package payFactorys.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import common.BasePageFactory;
import payUIs.nopcommerce.LoginPageUI;

public class LoginPageFactory extends BasePageFactory{
	private WebDriver driver;
	
	
	@FindBy(how = How.ID, using="Email")
	WebElement emailTextbox;
	
	@FindBy(how = How.ID, using="Password")
	WebElement passwordTextbox;
	
	@FindBy(how = How.XPATH, using="//button[contains(@class, 'login-button')]")
	WebElement loginButton;
	
	public LoginPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterToEmail(String emailAddress) {
		// TODO Auto-generated method stub
		//wait Email textbox dc visible
		waitForElementVisible(driver, emailTextbox);
		
		//send key vao email text box
		sendKeyToElement(driver, emailTextbox, emailAddress);
	}

	public void enterToPassword(String passWord) {
		// TODO Auto-generated method stub
		// wait Email textbox dc visible
		waitForElementVisible(driver, passwordTextbox);
		
		// send key vao email text box
		sendKeyToElement(driver,passwordTextbox, passWord);
	}

	public void clickToLoginButton() {
		// TODO Auto-generated method stub
		// wait ccho Login Button co the click dc
		waitForElementClickable(driver, loginButton);
		
		// click vao Login
		clickToElement(driver, loginButton);
		
	}

}
