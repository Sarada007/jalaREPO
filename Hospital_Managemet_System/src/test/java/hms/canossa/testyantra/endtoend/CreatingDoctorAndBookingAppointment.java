package hms.canossa.testyantra.endtoend;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

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

public class CreatingDoctorAndBookingAppointment {
	public static void main(String[] args) throws InterruptedException, IOException {
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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(URL);

		String homePageUrl = driver.getCurrentUrl();
		if (homePageUrl.contains("Hospital_Management_System")) {
			System.out.println("Hospital_Management_System web applications home page is displayed.");
		}

		driver.findElement(
				By.xpath("//h3[text()='Admin Login']/following-sibling::div[@class='button']//a[text()='Click Here']"))
				.click();

		String adminLoginPageUrl = driver.getCurrentUrl();
		if (adminLoginPageUrl.contains("Hospital_Management_System/hms/admin")) {
			System.out.println("Admin Login page is displayed.");
		}

		driver.findElement(By.name("username")).sendKeys(ADMIN_USERNAME);
		driver.findElement(By.name("password")).sendKeys(ADMIN_PASSWORD);
		driver.findElement(By.name("submit")).click();

		String adminDashBoardPageUrl = driver.getCurrentUrl();

		if (adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard")) {
			System.out.println("Admin dashboard page is displayed.");
		}

		driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
		driver.findElement(By.xpath("//span[text()=' Doctor Specialization ']")).click();
		String doctorSpecializationUrl = driver.getCurrentUrl();

		if (doctorSpecializationUrl.contains("doctor-specilization")) {
			System.out.println("Doctors specialization page is displayed.");
		}

		driver.findElement(By.name("doctorspecilization")).sendKeys(doctorSpecialization);
		driver.findElement(By.name("submit")).click();
		String dSMsg = driver
				.findElement(By.xpath("//p[normalize-space(text()='Doctor Specialization added successfully !!')]"))
				.getText();
		dSMsg = dSMsg.trim();
		List<WebElement> allSpecialization = driver
				.findElements(By.xpath("//td[@class='center']/following-sibling::td[@class='hidden-xs']"));
//		List<String> allSpecializationText = allSpecialization.stream().map(i -> i.getText())
//				.collect(Collectors.toList());

		if (dSMsg.equalsIgnoreCase("Doctor Specialization added successfully !!")) {
			System.out.println("Doctor Specialization added successfully. and message have came.");
		}

//		for (String i : allSpecializationText) {
//			if (i.equalsIgnoreCase(doctorSpecialization)) {
//				System.out.println("Doctor Specialization added successfully. Showing On the List of Specialization.");
//				break;
//			}
//		}

		driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
		driver.findElement(By.xpath("//span[text()=' Add Doctor']")).click();

		String addDoctorpageUrl = driver.getCurrentUrl();
		if (addDoctorpageUrl.contains("add-doctor")) {
			System.out.println("Add doctor page is displayed.");
		}

		Select s = new Select(driver.findElement(By.name("Doctorspecialization")));

		s.selectByVisibleText(doctorSpecialization);
		driver.findElement(By.name("docname")).sendKeys(doctorName);

		driver.findElement(By.name("clinicaddress")).sendKeys(doctorAdress);

		driver.findElement(By.name("docfees")).sendKeys(doctorFee);

		driver.findElement(By.name("doccontact")).sendKeys(doctorNumber);

		driver.findElement(By.name("docemail")).sendKeys(doctorMail);

		driver.findElement(By.name("npass")).sendKeys(doctorPassword);

		driver.findElement(By.name("cfpass")).sendKeys(doctorPassword);

		driver.findElement(By.name("submit")).click();

		String addDoctorAlertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		if (addDoctorAlertText.contains("Doctor info added Successfully")) {
			System.out.println("Alert has came. Doctor Added successfully.");
		}

		String manageDoctorHeading = driver.findElement(By.xpath("//section[@id='page-title']//h1")).getText();

		if (manageDoctorHeading.contains("Admin | Manage Doctors")) {
			System.out.println("Manage doctor page is displayed.");
		}

		driver.findElement(By.xpath("//span[@class='username']")).click();

		driver.findElement(By.xpath("//li/a[contains(text(),'Log Out')]")).click();

		String homePageUrl1 = driver.getCurrentUrl();

		if (homePageUrl1.contains("Hospital_Management_System")) {
			System.out.println("Hospital_Management_System web applications home page is displayed.");
		}

		driver.findElement(
				By.xpath("//h3[text()='Patients']/following-sibling::div[@class='button']//a[text()='Click Here']"))
				.click();
		String patientLoginPageUrl = driver.getCurrentUrl();

		if (patientLoginPageUrl.contains("Hospital_Management_System/hms/user-login")) {
			System.out.println("Patient login page is displayed.");
		}

		driver.findElement(By.name("username")).sendKeys(PATIENT_USERNAME);
		driver.findElement(By.name("password")).sendKeys(PATIENT_PASSWORD);
		driver.findElement(By.name("submit")).click();

		String patientDashboardPageUrl = driver.getCurrentUrl();

		if (patientDashboardPageUrl.contains("Hospital_Management_System/hms/dashboard")) {
			System.out.println("Patient Dashboard page is displayed.");
		}

		driver.findElement(By.xpath("//span[text()=' Book Appointment ']")).click();

		String bookAppointmentUrl = driver.getCurrentUrl();

		if (bookAppointmentUrl.contains("Hospital_Management_System/hms/book-appointment")) {
			System.out.println("Book appointment page is displayed in patient module");
		}

		Select s1 = new Select(driver.findElement(By.name("Doctorspecialization")));
		List<WebElement> allSp = s1.getOptions();

		for (WebElement i : allSp) {
			if (i.getText().contains(doctorSpecialization)) {
				System.out.println(
						"Specialization is present in the text field of Doctor specialization of Book appointment page of Patient module.");
				break;
			}
		}

		Select s2 = new Select(driver.findElement(By.name("doctor")));
		List<WebElement> allDoc = s2.getOptions();

		for (WebElement i : allDoc) {
			if (i.getText().contains(doctorName)) {
				System.out.println(
						"Doctor is present in the text field of Doctor of Book appointment page of Patient module.");
				break;
			}
		}

		driver.findElement(By.xpath("//span[@class='username']")).click();

		driver.findElement(By.xpath("//li/a[contains(text(),'Log Out')]")).click();

	}
}