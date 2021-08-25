package payFactorys.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import common.BasePageFactory;
import payUIs.user.nopcommerce.RegisterPageUI;

public class RegisterPageFactory extends BasePageFactory {
	private WebDriver driver;

	
	@FindBy(how = How.XPATH, using="//input[@id='gender-male']")
	WebElement maleRadioButton;
	
	@FindBy(how = How.XPATH, using="//input[@id='FirstName']")
	WebElement firstNameTextbox;
	
	@FindBy(how = How.XPATH, using="//input[@id='LastName']")
	WebElement lastNameTextbox;
	
	@FindBy(how = How.XPATH, using="//input[@id='Email']")
	WebElement emailTextbox;
	
	@FindBy(how = How.XPATH, using="//input[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(how = How.XPATH, using="//input[@id='ConfirmPassword']")
	WebElement confirmPasswordTextbox;

	@FindBy(how = How.XPATH, using="//button[@id='register-button']")
	WebElement registerButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='result' and text()='Your registration completed']")
	WebElement messageRegisterSuccess;
	
	@FindBy(how = How.XPATH, using="//a[@class='ico-logout']")
	WebElement logoutLink;
	

	public RegisterPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickToMaleRadioButton() {
		// TODO Auto-generated method stub
		// wait cho Radiobutton co the click dc
		waitForElementClickable(driver, maleRadioButton);
		
		// click vao Radio male
		clickToElement(driver, maleRadioButton);
	}

	public void enterToFirstName(String firstName) {
		// TODO Auto-generated method stub
		// wait cho Fist Name text box dc hien thi
		waitForElementVisible(driver, firstNameTextbox);
		// enter FirtName
		sendKeyToElement(driver, firstNameTextbox, firstName);

	}

	public void enterToLastName(String lastName) {
		// TODO Auto-generated method stub
		// wait cho Last Name text box dc hien thi
		waitForElementVisible(driver,lastNameTextbox);
		
		// enter Last Name
		sendKeyToElement(driver, lastNameTextbox, lastName);

	}

	public void enterToEmail(String email) {
		// TODO Auto-generated method stub
		// wait cho Email text box dc hien thi
		waitForElementVisible(driver, emailTextbox);
		// enter Email
		sendKeyToElement(driver, emailTextbox, email);
	}

	public void enterToPassWord(String passWord) {
		// TODO Auto-generated method stub
		// wait cho pass word text box dc hien thi
		waitForElementVisible(driver, passwordTextbox);
		// enter Pass word
		sendKeyToElement(driver, passwordTextbox, passWord);
	}

	public void enterToConfirmPassWord(String confirmPassword) {
		// TODO Auto-generated method stub
		// wait cho Confirm password text box dc hien thi
		waitForElementClickable(driver, confirmPasswordTextbox);
		// enter Confirm password
		sendKeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		//wait cho button co the click
		waitForElementClickable(driver, registerButton);
		//click vao button Register
		clickToElement(driver, registerButton);

	}

	public boolean isRegisterMessageSuccessDisplay() {
		// TODO Auto-generated method stub
		//wait cho message register sucess dc hien thi
		waitForElementVisible(driver, messageRegisterSuccess);
		return isElementDisplay(driver, messageRegisterSuccess);
		
	}

	public void clickToLogoutLink() {
		// TODO Auto-generated method stub
		//wait cho Logout link dc hien thi
		waitForElementClickable(driver, logoutLink);
		//click Logout
		clickToElement(driver, logoutLink);
	}

}
