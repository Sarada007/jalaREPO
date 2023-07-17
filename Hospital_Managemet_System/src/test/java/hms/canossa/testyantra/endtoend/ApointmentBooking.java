package hms.canossa.testyantra.endtoend;

import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ApointmentBooking {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		// Maximize the browser.
		driver.manage().window().maximize();

		// Provide implicit wait of 5 seconds.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Trigger the main URL.
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");

		// Check whether home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		if (homePageUrl.contains("Hospital_Management_System")) {
			System.out.println("The homepage is displayed");
		} else {
			System.out.println("The homepage is not displayed");
		}

		// Click on patient login.
		driver.findElement(By.xpath("//h3[text()='Patients']/..//a")).click();

		// Check whether patient login page is displayed or not.
		String patientLoginPageUrl = driver.getCurrentUrl();
		if (patientLoginPageUrl.contains("hms/user-login")) {
			System.out.println("The patient login page is displayed");
		} else {
			System.out.println("The patient login page is not displayed");
		}

		// Fill in the patient credentials and click on submit button.
		driver.findElement(By.name("username")).sendKeys("mani@outlook.com");
		driver.findElement(By.name("password")).sendKeys("Mani@123");
		driver.findElement(By.name("submit")).click();

		// Check whether the patient dash board page is displayed or not.
		String patientDashBoardPageUrl = driver.getCurrentUrl();
		if (patientDashBoardPageUrl.contains("hms/dashboard")) {
			System.out.println("The patient dash board page is displayed");
		} else {
			System.out.println("The patient dash board page is not displayed");
		}

		// Click on book appointment
		driver.findElement(By.xpath("//span[contains(.,'Book Appointment')]/../..")).click();

		// Check whether book appointment page is displayed or not.
		String bookappointmentPageUrl = driver.getCurrentUrl();
		if (bookappointmentPageUrl.contains("hms/book-appointment")) {
			System.out.println("The book appointment page is displayed");
		} else {
			System.out.println("The book appointment page is not displayed");
		}

		// Fill in all details and click on submit button.
		Select select = new Select(driver.findElement(By.xpath("//select[@name='Doctorspecialization']")));
		select.selectByValue("Neurologist");
		Select selectDoctor = new Select(driver.findElement(By.xpath("//select[@name='doctor']")));
		selectDoctor.selectByVisibleText("Mrutyunjaya");
		Date date = new Date();
		String[] splitDate = date.toString().split(" ");
		String day = splitDate[0];
		String month = splitDate[1];
		String dat = splitDate[2];
		String year = splitDate[5];
		String bookingDate = year + "-" + month + "-" + dat;
		driver.findElement(By.name("appdate")).sendKeys(bookingDate);
		System.out.println(bookingDate);
		driver.findElement(By.name("submit")).click();

		// Check whether appointment successfully booked alert is displaying or not.
		String appointmentBookedAlertPopup = driver.switchTo().alert().getText();
		if (appointmentBookedAlertPopup.contains("Your appointment successfully booked")) {
			System.out.println("Appointment successfully booked alert is displayed");
		} else {
			System.out.println("Appointment successfully booked alert is not displayed");
		}

		// Confirm the alert popup
		driver.switchTo().alert().accept();

		// Check whether book appointment page is displayed or not.
		bookappointmentPageUrl = driver.getCurrentUrl();
		if (bookappointmentPageUrl.contains("hms/book-appointment")) {
			System.out.println("The book appointment page is displayed");
		} else {
			System.out.println("The book appointment page is not displayed");
		}

		// Logout as patient.
		driver.findElement(By.xpath("//li[@class='dropdown current-user']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();

		// Check whether home page is displayed or not.
		homePageUrl = driver.getCurrentUrl();
		if (homePageUrl.contains("Hospital_Management_System")) {
			System.out.println("The homepage is displayed");
		} else {
			System.out.println("The homepage is not displayed");
		}

		// Click on Doctor login button
		driver.findElement(By.xpath("//h3[text()='Doctors Login']/..//a")).click();

		// Check whether Doctor Login page is displayed or not.
		String doctorLoginPageUrl = driver.getCurrentUrl();
		if (doctorLoginPageUrl.contains("hms/doctor")) {
			System.out.println("The Doctor Login page is displayed");
		} else {
			System.out.println("The Doctor Login page is not displayed");
		}

		// Filling credentials of doctor.
		driver.findElement(By.name("username")).sendKeys("mrutyunjaya@outlook.com");
		driver.findElement(By.name("password")).sendKeys("Mutun@123");
		driver.findElement(By.name("submit")).click();

		// Check whether doctor dash board page is displayed or not.
		String doctorDashBoardPageUrl = driver.getCurrentUrl();
		if (doctorDashBoardPageUrl.contains("hms/doctor/dashboard")) {
			System.out.println("The Doctor dash board page is displayed");
		} else {
			System.out.println("The Doctor dash board page is not displayed");
		}

		// Click on appointment history
		driver.findElement(
				By.xpath("//ul[@class='main-navigation-menu']//span[contains(text(),'Appointment History')]/../.."))
				.click();

		// Appointment history page should be displayed
		String appointmentHistoryPageUrl = driver.getCurrentUrl();
		if (appointmentHistoryPageUrl.contains("hms/doctor/appointment-history")) {
			System.out.println("The appointment history page is displayed");
		} else {
			System.out.println("The appointment history page is not displayed");
		}

		// Cancel the appointment
		String nameOfPatient = driver.findElement(By.xpath("//table[@id='sample-table-1']/tbody/tr/td[2]")).getText();
		List<WebElement> allActionMenu = driver.findElements(By.xpath("//table[@id='sample-table-1']/tbody/tr/td[8]"));
		for (int i = 0; i < allActionMenu.size(); i++) {
			String oneMenu = allActionMenu.get(i).getText();
			System.out.println(oneMenu);
			if (oneMenu.equals("Cancel")) {
				allActionMenu.get(i).click();
				break;
			}
		}
		
		// Cancellation alert popup
		String cancellationAlertText = driver.switchTo().alert().getText();
		if (cancellationAlertText.contains("Are you sure you want to cancel this appointment ?")) {
			System.out.println("The cancellation alert popup is displayed");
		} else {
			System.out.println("The cancellation alert popup is not displayed");
		}
		driver.switchTo().alert().accept();

		// Appointment history page should be displayed
		appointmentHistoryPageUrl = driver.getCurrentUrl();
		if (appointmentHistoryPageUrl.contains("hms/doctor/appointment-history")) {
			System.out.println("The appointment history page is displayed");
		} else {
			System.out.println("The appointment history page is not displayed");
		}

		// Logout as doctor.
		driver.findElement(By.xpath("//li[@class='dropdown current-user']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();

		// Check whether home page is displayed or not?
		homePageUrl = driver.getCurrentUrl();
		if (homePageUrl.contains("Hospital_Management_System")) {
			System.out.println("The homepage is displayed");
		} else {
			System.out.println("The homepage is not displayed");
		}

		// Click on patient login.
		driver.findElement(By.xpath("//h3[text()='Patients']/..//a")).click();

		// Check whether patient login page is displayed or not.
		patientLoginPageUrl = driver.getCurrentUrl();
		if (patientLoginPageUrl.contains("hms/user-login")) {
			System.out.println("The patient login page is displayed");
		} else {
			System.out.println("The patient login page is not displayed");
		}

		// Fill in the patient credentials and click on submit button.
		driver.findElement(By.name("username")).sendKeys("mani@outlook.com");
		driver.findElement(By.name("password")).sendKeys("Mani@123");
		driver.findElement(By.name("submit")).click();

		// Check whether the patient dash board page is displayed or not.
		patientDashBoardPageUrl = driver.getCurrentUrl();
		if (patientDashBoardPageUrl.contains("hms/dashboard")) {
			System.out.println("The patient dash board page is displayed");
		} else {
			System.out.println("The patient dash board page is not displayed");
		}

		// Navigate to Appointment History
		driver.findElement(
				By.xpath("//ul[@class='main-navigation-menu']//span[contains(.,'Appointment History')]/../..")).click();

		// Check whether appointment history page is displayed or not
		appointmentHistoryPageUrl = driver.getCurrentUrl();
		if (appointmentHistoryPageUrl.contains("hms/appointment-history")) {
			System.out.println("The appointment history page is displayed");
		} else {
			System.out.println("The appointment history page is not displayed");
		}
		driver.manage().window().minimize();
		driver.quit();

	}
}
