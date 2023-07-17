package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorPasswordRecoveryPage {
	WebDriver driver;

	public DoctorPasswordRecoveryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "contactno")
	private WebElement registeredContactNumber;
	public WebElement getRegisteredContactNumber()
	{
		return registeredContactNumber;
	}
	
	@FindBy(name = "email")
	private WebElement registeredMail;
	public WebElement getRegisteredMail()
	{
		return registeredMail;
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
	
	public void doctorPasswordRecovery(String doctorContactNumber , String doctorMail) {
		registeredContactNumber.sendKeys(doctorContactNumber);
		registeredMail.sendKeys(doctorMail);
		resetButton.click();
	}
}
