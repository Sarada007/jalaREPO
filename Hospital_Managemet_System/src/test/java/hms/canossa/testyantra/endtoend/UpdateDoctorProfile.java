package hms.canossa.testyantra.endtoend;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import hms.zeomedi.testyantra.genericutility.WebDriverUtility;
import hms.zeomedi.testyantra.pomrepository.DoctorLoginPage;
import hms.zeomedi.testyantra.pomrepository.HomePage;

public class UpdateDoctorProfile {
	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/comman.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String ADMINLOGINID = p.getProperty("adminLoginID");
		String ADMINPASSWORD = p.getProperty("adminPassword");
		String PTLOGINID = p.getProperty("ptLoginID");
		String PTPASSWORD = p.getProperty("ptPassword");
		String DOCLOGINID = p.getProperty("docLoginID");
		String DOCPASSWORD = p.getProperty("docPassword");
		

		FileInputStream fis1 = new FileInputStream("./src/test/resources/hmsTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Row row = wb.getSheet("Update_Doctor_Profile").getRow(1);
		String dcSp = row.getCell(0).toString();
		String doctor = row.getCell(1).toString();
		String cliAdd = row.getCell(2).toString();
		String docFee = row.getCell(3).toString();
		String docContact = row.getCell(4).toString();
		
		WebDriverUtility wdu = new WebDriverUtility();

		// open the chrome browser.
		WebDriver driver = new ChromeDriver();

		// Maximize the window.
		wdu.maximizeTheBrowser(driver);
		//driver.manage().window().maximize();

		// Giving implicitly wait.
		wdu.implicitWait(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// enter the url.
		driver.get(URL);

		// Verifying weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		if (homePageUrl.contains("Hospital_Management_System")) {
			System.out.println("Hospital_Management_System web applications home page is displayed.");
		}
		else {
			System.out.println("Hospital_Management_System web applications home page is not displayed.");
		}
		
		HomePage homePage = new HomePage(driver);
		DoctorLoginPage doctorLoginPage = new DoctorLoginPage(driver);
		
		
		homePage.getDoctorClickHereButton();
		doctorLoginPage.doctorLogin(DOCLOGINID, DOCPASSWORD);
//		driver.findElement(By.name("username")).sendKeys(DOCLOGINID);
//		driver.findElement(By.name("password")).sendKeys(DOCPASSWORD);
//		driver.findElement(By.name("submit")).click();

		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();

		Select s = new Select(driver.findElement(By.name("Doctorspecialization")));

		s.selectByVisibleText(dcSp);

		driver.findElement(By.name("docname")).clear();
		driver.findElement(By.name("docname")).sendKeys(doctor);

		driver.findElement(By.name("clinicaddress")).clear();
		driver.findElement(By.name("clinicaddress")).sendKeys(cliAdd);

		driver.findElement(By.name("docfees")).clear();
		driver.findElement(By.name("docfees")).sendKeys(docFee);

		driver.findElement(By.name("doccontact")).clear();
		driver.findElement(By.name("doccontact")).sendKeys(docContact);

		driver.findElement(By.name("submit")).click();

		driver.switchTo().alert().accept();

		String editDocPage = driver.getCurrentUrl();

		if (editDocPage.contains("Hospital_Management_System/hms/doctor/edit-profile")) {
			System.out.println("Edit doctor page is displayed.");
		}
	}
}
