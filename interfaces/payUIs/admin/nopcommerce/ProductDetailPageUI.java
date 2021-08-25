package payUIs.admin.nopcommerce;

public class ProductDetailPageUI {
	public static final String TOOGLE_ICON_BY_CARD_NAME ="//div[@class='card-title' and contains(string(),'%s')]/following-sibling::div//i";
	public static final String UPLOAD_FILE_BUTTON="//div[@id='product-pictures']//input[@type='file']";
	public static final String PRODUCT_IMAGE_BY_NAME="//div[@class='upload-picture-block']//img[contains(@src,'%s')]";
	public static final String ALT_TEXTBOX="//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX="//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAY_ORDER_TEXTBOX="//input[@id='AddPictureModel_DisplayOrder']/preceding-sibling::input";
	public static final String ADD_PRODUCT_PICTURE_BUTTON="//button[@id='addProductPicture']";
	public static final String PICTURE_TABLE_INFO="//img[contains(@src,'%s')]/parent::a/parent::td/following-sibling::td[@data-columnname='DisplayOrder' and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='%s']";
	public static final String SAVE_BUTTON="//button[@name='save']";
	public static final String DELETE_IMAGE_PRODUCT_IN_TABLE_BY_CARDNAME="//table[@id='%s-grid']//tbody//tr//td[contains(@class,'button-column')]/a[contains(string(),'Delete')]/i";
	public static final String MESSAGE_IN_EMPTY_TABLE="//table[@id='%s-grid']//td[@class='dataTables_empty' and text()='%s']";
	public static final String UP_DOWN_VALUE_BUTTON_BY_CARD_NAME="//div[@id='%s']//span[@aria-label='%s']";
}
