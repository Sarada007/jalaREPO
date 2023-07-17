package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	WebDriver driver;

	public PatientLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "username")
	private WebElement usernameTextField;
	public WebElement getUsernameTextField()
	{
		return usernameTextField;
	}
	
	@FindBy(name = "password")
	private WebElement passwordTextField;
	public WebElement getPasswordTextField()
	{
		return passwordTextField;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Forgot Password ?')]")
	private WebElement forgotPasswordLink;
	public WebElement getForgotPasswordLink()
	{
		return forgotPasswordLink;
	}
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	public WebElement getSubmitButton()
	{
		return submitButton;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Create an account')]")
	private WebElement createAnAccountLink;
	public WebElement getCreateAnAccountLink()
	{
		return createAnAccountLink;
	}
	
	public void patientLogin(String patientUsername , String patientPassword) {
		usernameTextField.sendKeys(patientUsername);
		passwordTextField.sendKeys(patientPassword);
		submitButton.click();
	}
}
