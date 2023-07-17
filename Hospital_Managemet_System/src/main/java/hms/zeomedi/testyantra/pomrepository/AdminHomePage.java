package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='dashboard.php']")
	private WebElement dashboardMenu;

	@FindBy(xpath = "//span[(text()=' Doctors ')]/../..")
	private WebElement doctorsMenu;

	@FindBy(xpath = "//span[text()=' Users ']/../..")
	private WebElement usersMenu;

	@FindBy(xpath = "//span[text()=' Patients ']/../..")
	private WebElement patientsMenu;

	@FindBy(xpath = "//a[@href='appointment-history.php']")
	private WebElement appointmentMenu;

	@FindBy(xpath = "//span[text()=' Conatctus Queries ']/../..")
	private WebElement querryMenu;

	@FindBy(xpath = "//a[@href='doctor-logs.php']")
	private WebElement doctorSessionLogsMenu;

	@FindBy(xpath = "//a[@href='user-logs.php']")
	private WebElement userSessionLogsMenu;

	@FindBy(xpath = "//span[text()=' Reports ']/../..")
	private WebElement reportsMenu;

	@FindBy(xpath = "//a[@href='patient-search.php']")
	private WebElement searchMenu;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement adminDropdown;

	@FindBy(xpath = "//a[@href='doctor-specilization.php']")
	private WebElement doctorSpecializationSubMenu;

	@FindBy(xpath = "//a[@href='add-doctor.php']")
	private WebElement addDoctorSubMenu;

	@FindBy(xpath = "//a[@href='Manage-doctors.php']")
	private WebElement manageDoctorSubMenu;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']//a[@href='manage-users.php']")
	private WebElement manageUsersSubMenu;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']//a[@href='manage-patient.php']")
	private WebElement managePatientSubMenu;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']//a[@href='unread-queries.php']")
	private WebElement unreadQuerriesSubMenu;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']//a[@href='read-query.php']")
	private WebElement readQuerriesSubMenu;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']//a[@href='between-dates-reports.php']")
	private WebElement betweenDatesReportSubMenu;

	@FindBy(xpath = "//a[@href='change-password.php']")
	private WebElement changePassword;

	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logOut;

	public WebElement getDashboardMenu() {
		return dashboardMenu;
	}

	public WebElement getDoctorsMenu() {
		return doctorsMenu;
	}

	public WebElement getUsersMenu() {
		return usersMenu;
	}

	public WebElement getPatientsMenu() {
		return patientsMenu;
	}

	public WebElement getAppointmentMenu() {
		return appointmentMenu;
	}

	public WebElement getQuerryMenu() {
		return querryMenu;
	}

	public WebElement getDoctorSessionLogsMenu() {
		return doctorSessionLogsMenu;
	}

	public WebElement getUserSessionLogsMenu() {
		return userSessionLogsMenu;
	}

	public WebElement getReportsMenu() {
		return reportsMenu;
	}

	public WebElement getSearchMenu() {
		return searchMenu;
	}

	public WebElement getAdminDropdown() {
		return adminDropdown;
	}

	public WebElement getDoctorSpecializationSubMenu() {
		return doctorSpecializationSubMenu;
	}

	public WebElement getAddDoctorSubMenu() {
		return addDoctorSubMenu;
	}

	public WebElement getManageDoctorSubMenu() {
		return manageDoctorSubMenu;
	}

	public WebElement getManageUsersSubMenu() {
		return manageUsersSubMenu;
	}

	public WebElement getManagePatientSubMenu() {
		return managePatientSubMenu;
	}

	public WebElement getUnreadQuerriesSubMenu() {
		return unreadQuerriesSubMenu;
	}

	public WebElement getReadQuerriesSubMenu() {
		return readQuerriesSubMenu;
	}

	public WebElement getBetweenDatesReportSubMenu() {
		return betweenDatesReportSubMenu;
	}

	public WebElement getChangePassword() {
		return changePassword;
	}

	public WebElement getLogOut() {
		return logOut;
	}
	
	public void adminLogout() {
		adminDropdown.click();
		logOut.click();
	}
}
