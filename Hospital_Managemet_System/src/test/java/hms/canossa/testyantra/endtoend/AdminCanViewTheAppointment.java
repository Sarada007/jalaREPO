package hms.canossa.testyantra.endtoend;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminCanViewTheAppointment {
	public static void main(String[] args) throws Throwable {
		// open the chrome browser.

		WebDriver driver;
		FileInputStream fisp = new FileInputStream("./src/test/resources/Common Data.properties");

		Random radNum = new Random();
		int ranNum = radNum.nextInt(1000);

		Properties prop = new Properties();
		prop.load(fisp);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String ADMIN_USERNAME = prop.getProperty("admin_username");
		String ADMIN_PASSWORD = prop.getProperty("admin_password");
		String DOCTOR_USERNAME = prop.getProperty("doctor_username");
		String DOCTOR_PASSWORD = prop.getProperty("doctor_password");
		String PATIENT_USERNAME = prop.getProperty("patient_username");
		String PATIENT_PASSWORD = prop.getProperty("patient_password");

		FileInputStream fise = new FileInputStream("./src/test/resources/Test Data.xlsx");
		Workbook workBook = WorkbookFactory.create(fise);
		Sheet sheet = workBook.getSheet("Doctor Details");
		String doctorSpecialization = sheet.getRow(0).getCell(0).toString();
		String doctorName = sheet.getRow(1).getCell(0).toString();
		String doctorAdress = sheet.getRow(2).getCell(0).toString();
		String doctorFee = sheet.getRow(3).getCell(0).toString();
		String doctorNumber = sheet.getRow(4).getCell(0).toString();
		String doctorMail = sheet.getRow(5).getCell(0).toString();
		String doctorPassword = sheet.getRow(6).getCell(0).toString();

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else
			driver = new ChromeDriver();

		// Maximize the window.
		driver.manage().window().maximize();

		// Giving implicitly wait.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// enter the url.
		driver.get(URL);

		// Varifing weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		if (homePageUrl.contains("Hospital_Management_System")) {
			System.out.println("Hospital_Management_System web applications home page is displayed.");
		}

		// Go to patient login page.
		driver.findElement(
				By.xpath("//h3[text()='Patients']/following-sibling::div[@class='button']//a[text()='Click Here']"))
				.click();

		// Varifing weather patient log in page is displayed or not.
		String patientLoginPageUrl = driver.getCurrentUrl();
		if (patientLoginPageUrl.contains("Hospital_Management_System/hms/user-login")) {
			System.out.println("Patient login page is displayed.");
		}

		// Enter the valid credential of Patient(User) and click on submit.
		driver.findElement(By.name("username")).sendKeys(PATIENT_USERNAME);
		driver.findElement(By.name("password")).sendKeys(PATIENT_PASSWORD);
		driver.findElement(By.name("submit")).click();

		// Verifying weather Patient dash board page is displayed or not.
		String patientDashboardPageUrl = driver.getCurrentUrl();
		if (patientDashboardPageUrl.contains("Hospital_Management_System/hms/dashboard")) {
			System.out.println("Patient Dashboard page is displayed.");
		}

		// Click on Book appointment Button.
		driver.findElement(By.xpath("//span[text()=' Book Appointment ']")).click();

		// Verifying weather book appointment page is displayed or not.
		String bookAppointmentUrl = driver.getCurrentUrl();
		if (bookAppointmentUrl.contains("Hospital_Management_System/hms/book-appointment")) {
			System.out.println("Book appointment page is displayed in patient module.");
		}

		// select The doctor specialization.
		Select s1 = new Select(driver.findElement(By.name("Doctorspecialization")));
		s1.selectByVisibleText(doctorSpecialization);

		// select the doctor.
		Select s2 = new Select(driver.findElement(By.name("doctor")));
		s2.selectByVisibleText(doctorName);

		// select the date.
		driver.findElement(By.name("appdate")).click();
		driver.findElement(By.xpath("//td[@class='day' and text()='19']")).click();

		// select the time.
		driver.findElement(By.name("apptime")).click();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour form-control']")).clear();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour form-control']")).sendKeys("4");
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-minute form-control']")).clear();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-minute form-control']")).sendKeys("30");
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-meridian form-control']")).clear();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-meridian form-control']")).sendKeys("PM");

		// click on submit button.
		driver.findElement(By.name("submit")).click();

		// Getting text from Alert pop up.
		String bookMsg = driver.switchTo().alert().getText();

		// Verifying the text of alert pop up.
		if (bookMsg.contains("Your appointment successfully booked")) {
			System.out.println("Appointment is booked successfully.");
		}

		// clicking ok on alert pop up.
		driver.switchTo().alert().accept();

		// logout as a Patient.
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//li/a[contains(text(),'Log Out')]")).click();

		// verifying weather home page is displayed or not.
		String homePageUrl1 = driver.getCurrentUrl();
		if (homePageUrl1.contains("Hospital_Management_System")) {
			System.out.println("Hospital_Management_System web applications home page is displayed.");
		}

		// Go to admin login page.
		driver.findElement(
				By.xpath("//h3[text()='Admin Login']/following-sibling::div[@class='button']//a[text()='Click Here']"))
				.click();

		// varifing weather Admin log in page is displayed or not.
		String adminLoginPageUrl = driver.getCurrentUrl();
		if (adminLoginPageUrl.contains("Hospital_Management_System/hms/admin")) {
			System.out.println("Admin Login page is displayed.");
		}

		// click on valid credential of admin.
		driver.findElement(By.name("username")).sendKeys(ADMIN_USERNAME);///////////////////
		driver.findElement(By.name("password")).sendKeys(ADMIN_PASSWORD);////////////////////////
		driver.findElement(By.name("submit")).click();

		// varifing weather Admin log in page is displayed or not.
		String adminDashBoardPageUrl = driver.getCurrentUrl();
		if (adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard")) {
			System.out.println("Admin dashboard page is displayed.");
		}

		// click on appointment history of Admin dashboard page.
		driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click();

		// varifing weather appointment history page is display or not.
		String AppointmentHistoryPageHeading = driver.findElement(By.xpath("//section[@id='page-title']//h1"))
				.getText();
		if (AppointmentHistoryPageHeading.contains("Patients  | Appointment History")) {
			System.out.println("Appointment History page is displayed.");
		}

		// making list of all patient.
		List<WebElement> allPatient = driver.findElements(By.xpath("//tr/td[@class='hidden-xs'][2]"));
		String patientName = workBook.getSheet("Patient Details").getRow(0).getCell(0).toString();

		// varifing weather patient's appointment is present in list or not.
		for (WebElement i : allPatient) {
			if (i.getText().contains(patientName)) {
				System.out.println("Booked Appointment by " + patientName + " is showing in the list.");
				break;
			}
		}

		// logout as a admin.
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//li/a[contains(text(),'Log Out')]")).click();

		// Checking weather homepage is displayed or not.
		String homePageUrl2 = driver.getCurrentUrl();
		if (homePageUrl2.contains("Hospital_Management_System")) {
			System.out.println("Hospital_Management_System web applications home page is displayed.");
		}
	}
}
