package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
	WebDriver driver;

	public DoctorLoginPage(WebDriver driver) {
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
	
	public void doctorLogin(String doctorUsername , String doctorPassword) {
		usernameTextField.sendKeys(doctorUsername);
		passwordTextField.sendKeys(doctorPassword);
		submitButton.click();
	}
}
