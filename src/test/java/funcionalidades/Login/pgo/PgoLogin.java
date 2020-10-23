package funcionalidades.Login.pgo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Capabilities;

public class PgoLogin {
	
	public PgoLogin() {
		PageFactory.initElements(Capabilities.getDriver(), this);
	}
	
	/**
	 * Lista de Menus
	 */
	
	@FindBy(css = "a.login")
	public WebElement MENU_SIGN_IN;

	@FindBy(css = "a.logout")
	public WebElement MENU_SIGN_OUT;
	
	/**
	 * Lista de Botões
	 */
	
	@FindBy(css = "#SubmitCreate span")
	public WebElement BTN_CREATE_ACCOUNT;
	
	@FindBy(css = "#SubmitLogin span")
	public WebElement BTN_SIGN_IN;

	@FindBy(id = "submitAccount")
	public WebElement BTN_REGISTER;
	
	/**
	 * Lista de Campos
	 */
	
	@FindBy(id = "email_create")
	public WebElement CMP_EMAIL_CADASTRO;

	@FindBy(id = "email")
	public WebElement CMP_EMAIL;
	
	@FindBy(id = "passwd")
	public WebElement CMP_SENHA;
	
	@FindBy(id = "days")
	public WebElement CMP_DAY;
	
	@FindBy(id = "months")
	public WebElement CMP_MONTH;
	
	@FindBy(id = "years")
	public WebElement CMP_YEAR;

	@FindBy(id = "id_gender1")
	public WebElement CMP_RADIO_MR;
	
	@FindBy(id = "id_gender2")
	public WebElement CMP_RADIO_MRS;

	@FindBy(id = "customer_firstname")
	public WebElement CMP_FIRST_NAME;

	@FindBy(id = "customer_lastname")
	public WebElement CMP_LAST_NAME;

	@FindBy(id = "company")
	public WebElement CMP_COMPANY;

	@FindBy(id = "address1")
	public WebElement CMP_ADDRESS;
	
	@FindBy(id = "city")
	public WebElement CMP_CITY;
	
	@FindBy(id = "id_state")
	public WebElement CMP_STATE;
	
	@FindBy(id = "postcode")
	public WebElement CMP_POSTAL_CODE;
	
	@FindBy(id = "id_country")
	public WebElement CMP_COUNTRY;
	
	@FindBy(id = "phone_mobile")
	public WebElement CMP_PHONE_MOBILE;
	
	@FindBy(id = "alias")
	public WebElement CMP_ALIAS;
	
	/**
	 * Alertas
	 */

	@FindBy(css = "div .alert.alert-danger li")
	public WebElement ALERT_MESSAGE;
	
	/**
	 * Labels
	 */

	@FindBy(css = ".info-account")
	public WebElement WELCOME_MESSAGE;

	@FindBy(css = ".logo.img-responsive")
	public WebElement LOGO_TELA_INICIAL;
}