package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorHomePage {
	public DoctorHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='dashboard.php']")
	private WebElement doctorDashboardMenu;

	@FindBy(xpath = "//a[@href='appointment-history.php']")
	private WebElement appointmentHistoryMenu;

	@FindBy(xpath = "//span[text()=' Patients ']/../..")
	private WebElement patientsMenu;

	@FindBy(xpath = "//a[@href='search.php']")
	private WebElement searchMenu;

	@FindBy(xpath = "//a[@href='add-patient.php']")
	private WebElement addPatientSubMenu;

	@FindBy(xpath = "//a[@href='manage-patient.php']")
	private WebElement managePatientSubMenu;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement adminDropdown;

	@FindBy(xpath = "//a[@href='edit-profile.php']")
	private WebElement doctorProfile;

	@FindBy(xpath = "//a[@href='change-password.php']")
	private WebElement changePassword;

	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logOut;

	public WebElement getDoctorDashboardMenu() {
		return doctorDashboardMenu;
	}

	public WebElement getAppointmentHistoryMenu() {
		return appointmentHistoryMenu;
	}

	public WebElement getPatientsMenu() {
		return patientsMenu;
	}

	public WebElement getSearchMenu() {
		return searchMenu;
	}

	public WebElement getAddPatientSubMenu() {
		return addPatientSubMenu;
	}

	public WebElement getManagePatientSubMenu() {
		return managePatientSubMenu;
	}

	public WebElement getAdminDropdown() {
		return adminDropdown;
	}

	public WebElement getDoctorProfile() {
		return doctorProfile;
	}

	public WebElement getChangePassword() {
		return changePassword;
	}

	public WebElement getLogOut() {
		return logOut;
	}

}
