package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//li[@class='active']/a")
	private WebElement homeOption;
	public WebElement getHomeOption()
	{
		return homeOption;
	}
	
	@FindBy(xpath = "//div[@class='top-nav']//a[text()='contact']")
	private WebElement contactOption;
	public WebElement getContactOption()
	{
		return contactOption;
	}
	
	@FindBy(xpath = "//h3[text()='Patients']/..//a")
	private WebElement patientClickHereButton;
	public WebElement getPatientClickHereButton()
	{
		return patientClickHereButton;
	}
	
	@FindBy(xpath = "//h3[text()='Doctors Login']/..//a")
	private WebElement doctorClickHereButton;
	public WebElement getDoctorClickHereButton()
	{
		return doctorClickHereButton;
	}
	
	@FindBy(xpath = "//h3[text()='Admin Login']/..//a")
	private WebElement adminClickHereButton;
	public WebElement getAdminClickHereButton() 
	{
		return adminClickHereButton;
	}	
}
