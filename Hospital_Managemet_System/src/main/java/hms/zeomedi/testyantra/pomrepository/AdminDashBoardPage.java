package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoardPage {
	public AdminDashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='row']//a[@href='manage-users.php']")
	private WebElement manageUsersLink;

	@FindBy(xpath = "//div[@class='row']//a[@href='manage-doctors.php']")
	private WebElement manageDoctorsLink;

	@FindBy(xpath = "//div[@class='row']//a[@href='appointment-history.php']")
	private WebElement appointmentHistoryLink;

	@FindBy(xpath = "//div[@class='row']//a[@href='manage-patient.php']")
	private WebElement managePatientLink;

	@FindBy(xpath = "//div[@class='row']//a[@href='unread-queries.php']")
	private WebElement unreadQuerriesLink;

	public WebElement getManageUsersLink() {
		return manageUsersLink;
	}

	public WebElement getManageDoctorsLink() {
		return manageDoctorsLink;
	}

	public WebElement getAppointmentHistoryLink() {
		return appointmentHistoryLink;
	}

	public WebElement getManagePatientLink() {
		return managePatientLink;
	}

	public WebElement getUnreadQuerriesLink() {
		return unreadQuerriesLink;
	}
}
