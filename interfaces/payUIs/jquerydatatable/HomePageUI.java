package payUIs.jquerydatatable;

public class HomePageUI {
	public static final String LOAD_DATA_BUTTON="//button[@id='load']";
	public static final String TABLE_DATA="//tbody//tr";
	public static final String ICON_BY_NAME="//button[@title='%s']";
	public static final String COLUMN_INDEX_BY_NAME="//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_ROW_INDEX="//tbody//tr[%s]/td[%s]/input";
	public static final String COUNTRY_DROPDOWN="//tr[%s]/td[%s]//select";
	public static final String NPO_CHECKBOX="//tr[%s]/td[%s]/label[@class='checkbox']/input";
	public static final String ACTIONS_IN_ROW="//tbody/tr[%s]//button[@title='%s']";
	public static final String PAGGING_BY_NUMBER="//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGGING_BY_NUMBER_ACTIVE="//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TEXTBOX_BY_COLUMN_NAME="//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL="//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String ACTIONS_IN_ROW_BY_COUNTRY_NAME="//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	public static final String LIST_COUNTRY="//tbody/tr/td[@data-key='country']";
	public static final String POPUP_EDIT_COUNTRY="//form[@class='qgrd-modal-form']";
	public static final String ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL_IN_POPUP="//input[@name='females' and @value='%s']/parent::div/following-sibling::div/input[@name='country' and @value='%s']/parent::div/following-sibling::div/input[@name='males' and @value='%s']/parent::div/following-sibling::div/input[@name='total' and @value='%s']";
	public static final String CLOSE_POPUP="//button[@class='qgrd-modal-dismiss']";
}

