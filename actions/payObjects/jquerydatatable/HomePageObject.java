package payObjects.jquerydatatable;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import payUIs.jquerydatatable.HomePageUI;

public class HomePageObject  extends BasePage{
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void clickLoadDataButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver,HomePageUI.LOAD_DATA_BUTTON);
	}
	
	public int getRowInDataTable() {
		// TODO Auto-generated method stub
		return getElementSize(driver, HomePageUI.TABLE_DATA);
	}
	public void clickToIconByName(String iconName) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.ICON_BY_NAME, iconName);
		clickToElement(driver, HomePageUI.ICON_BY_NAME, iconName);
	}
	public void inputToTextboxByRowNumber(String columnName, String rowIndex, String value) {
		// TODO Auto-generated method stub
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX,rowIndex, String.valueOf(columnIndex));
		sendKeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, value,rowIndex, String.valueOf(columnIndex) );
	}
	public void selectCountry(String columnName, String rowIndex, String value) {
		// TODO Auto-generated method stub
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
		waitForElementVisible(driver, HomePageUI.COUNTRY_DROPDOWN, rowIndex, String.valueOf(columnIndex));
		selectItemInDefaultDropdownByText(driver,HomePageUI.COUNTRY_DROPDOWN, value, rowIndex, String.valueOf(columnIndex));
	}
	public String getCountrySelected(String columnName, String rowIndex) {
		// TODO Auto-generated method stub
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
		return getSelectedItemInDefaultDropdown(driver, HomePageUI.COUNTRY_DROPDOWN,rowIndex, String.valueOf(columnIndex));
		
	}
	public void checkToCheckbox(String columnName, String rowIndex) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
		waitForElementVisible(driver, HomePageUI.NPO_CHECKBOX, rowIndex, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrDefaultRadio(driver, HomePageUI.NPO_CHECKBOX, rowIndex, String.valueOf(columnIndex));
		// TODO Auto-generated method stub
		
	}
	public boolean isCheckboxSelected(String columnName, String rowIndex) {
		// TODO Auto-generated method stub
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
		return isElementSelected(driver, HomePageUI.NPO_CHECKBOX, rowIndex, String.valueOf(columnIndex));
		
	}
	public void clickToIconByRowNumber(String rowIndex, String iconTitle) {
		waitForElementVisible(driver,HomePageUI.ACTIONS_IN_ROW,rowIndex, iconTitle);
		clickToElement(driver,HomePageUI.ACTIONS_IN_ROW,rowIndex, iconTitle);
		// TODO Auto-generated method stub
		
	}
	public void clickToPageNumber(String pageNumber) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.PAGGING_BY_NUMBER,pageNumber);
		clickToElement(driver, HomePageUI.PAGGING_BY_NUMBER,pageNumber);
		
	}
	public boolean isPageNumberActive(String pageNumber) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.PAGGING_BY_NUMBER_ACTIVE,pageNumber);
		return isElementDisplay(driver, HomePageUI.PAGGING_BY_NUMBER_ACTIVE,pageNumber);
		
	}
	public void searchInColumnName(String columnName, String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_NAME,columnName);
		sendKeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_NAME, value, columnName);
		pressKeyboardToElemnt(driver, HomePageUI.TEXTBOX_BY_COLUMN_NAME,Keys.ENTER,columnName);
		
	}
	public boolean isRowValueDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, female, country, male, total);
		return isElementDisplay(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, female, country, male, total);
		// TODO Auto-generated method stub
		
	}
	public void clickToIconByCountryName(String countryName, String action) {
		waitForElementClickable(driver,HomePageUI.ACTIONS_IN_ROW_BY_COUNTRY_NAME, countryName,action);
		clickToElement(driver,HomePageUI.ACTIONS_IN_ROW_BY_COUNTRY_NAME, countryName,action);
		
		
	}
	public boolean isDeleteSucceed(String countryName) {
		boolean isSucceed=true;
		// TODO Auto-generated method stub
		List<WebElement> listElements=getListWebElements(driver, HomePageUI.LIST_COUNTRY);
		for (WebElement webElement : listElements) {
			if(webElement.getText().equals(countryName)) {
				isSucceed = false;
				break;
			}
		}
		return isSucceed;
	}
	public boolean isPopupEditCountryDisplayed() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,HomePageUI.POPUP_EDIT_COUNTRY);
		return isElementDisplay(driver, HomePageUI.POPUP_EDIT_COUNTRY);
		
	}
	public boolean verifyValueInRow(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL_IN_POPUP, female,country,male,total);
		return isElementDisplay(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL_IN_POPUP, female,country,male,total);
		// TODO Auto-generated method stub
		
	}
	public void closeEditPopup() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.CLOSE_POPUP);
		clickToElement(driver,HomePageUI.CLOSE_POPUP);
	}
}
