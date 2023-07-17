package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientPasswordRecoveryPage {
	WebDriver driver;

	public PatientPasswordRecoveryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "fullname")
	private WebElement registeredFullName;
	public WebElement getRegisteredFullName()
	{
		return registeredFullName;
	}
	
	@FindBy(name = "email")
	private WebElement registeredEmail;
	public WebElement getRegisteredEmail()
	{
		return registeredEmail;
	}
	
	@FindBy(name = "submit")
	private WebElement resetButton;
	public WebElement getResetButton()
	{
		return resetButton;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Log-in')]")
	private WebElement loginLink;
	public WebElement getLoginLink()
	{
		return loginLink;
	}
	
	public void patientPasswordRecovery(String patientFullName , String patientMail) {
		registeredFullName.sendKeys(patientFullName);
		registeredEmail.sendKeys(patientMail);
		resetButton.click();
	}
}
