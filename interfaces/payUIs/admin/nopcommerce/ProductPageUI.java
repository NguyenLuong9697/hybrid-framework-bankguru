package payUIs.admin.nopcommerce;

public class ProductPageUI {
	public static final String PRODUCT_NAME_TEXTBOX="//input[@name='SearchProductName']";
	public static final String SEARCH_BUTTON="//button[@id='search-products']";
	public static final String EDIT_ICON_BY_PRODUCT_NAME="//td[text()='%s']/following-sibling::td[contains(@class,'button-column')]/a/i";
	public static final String SUCCESS_MESSAGE="//div[contains(@class,'alert-success') and contains(string(),'%s')]";
	public static final String IMAGE_PRODUCT_BY_PRODUCT_NAME="//td[text()='%s']/preceding-sibling::td/img[contains(@src,'%s')]";
	public static final String ICON_EXPAND_SEARCH_PANEL="//div[@class='icon-collapse']/i";
	
}
