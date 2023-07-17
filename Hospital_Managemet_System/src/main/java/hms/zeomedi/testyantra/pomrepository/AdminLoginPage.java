package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	WebDriver driver;

	public AdminLoginPage(WebDriver driver) {
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
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	public WebElement getSubmitButton()
	{
		return submitButton;
	}
	
	public void adminLogin(String adminUsername , String adminPassword) {
		usernameTextField.sendKeys(adminUsername);
		passwordTextField.sendKeys(adminPassword);
		submitButton.click();
	}
}
