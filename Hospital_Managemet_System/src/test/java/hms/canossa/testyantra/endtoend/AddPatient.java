package hms.canossa.testyantra.endtoend;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddPatient {
	public static void main(String[] args) throws IOException, InterruptedException {
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
		Row row = wb.getSheet("AddPatient").getRow(1);
		String pName = row.getCell(0).toString();
		long pContact = (long) row.getCell(1).getNumericCellValue();
		String pEmail = row.getCell(2).toString();
		String pGender = row.getCell(3).toString();
		String pAddress = row.getCell(4).toString();
		String pAge = row.getCell(5).toString();
		String pMH = row.getCell(6).toString();

		Random ran = new Random();
		int r = (int) ran.nextInt(1000);

		// open the chrome browser.
		WebDriver driver = new ChromeDriver();

		// Maximize the window.
		driver.manage().window().maximize();

		// Giving implicitly wait.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// enter the url.
		driver.get(URL);

		// Verifying weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		if (homePageUrl.contains("Hospital_Management_System")) {
			System.out.println("Hospital_Management_System web applications home page is displayed.");
		}

		driver.findElement(By
				.xpath("//h3[text()='Doctors Login']/following-sibling::div[@class='button']//a[text()='Click Here']"))
				.click();
		driver.findElement(By.name("username")).sendKeys(DOCLOGINID);
		driver.findElement(By.name("password")).sendKeys(DOCPASSWORD);
		driver.findElement(By.name("submit")).click();

		driver.findElement(By.xpath("//div[@class='item-inner']/span[text()=' Patients ']")).click();

		driver.findElement(By.xpath("//a/span[text()=' Add Patient']")).click();

		driver.findElement(By.name("patname")).sendKeys(pName + r);

//	DataFormatter d = new DataFormatter();
//	String s = d.formatCellValue(row.getCell(1));
		String s = Long.toString(pContact);
		driver.findElement(By.name("patcontact")).sendKeys(s);

		String[] temp = pEmail.split("@");
		pEmail = temp[0] + r + "@" + temp[1];

		driver.findElement(By.name("patemail")).sendKeys(pEmail);

		pGender = pGender.toLowerCase();

		driver.findElement(By.xpath("//label[@for='rg-" + pGender + "']")).click();

		driver.findElement(By.name("pataddress")).sendKeys(pAddress + r);

		driver.findElement(By.name("patage")).sendKeys(pAge);

		driver.findElement(By.name("medhis")).sendKeys(pMH);
		Thread.sleep(3000);
		driver.findElement(By.name("submit")).click();

		driver.findElement(By.xpath("//div[@class='item-inner']/span[text()=' Patients ']")).click();

		driver.findElement(By.xpath("//a/span[text()=' Manage Patient ']")).click();
		Thread.sleep(3000);
		List<WebElement> ptName = driver.findElements(By.xpath("//td[@class='hidden-xs']"));

		for (WebElement i : ptName) {
			if (i.getText().contains(pName + r)) {
				System.out.println("Patient present in the list.");
				break;
			}
		}
		// logout the application
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();

		// Checking weather home page is displayed or not.
		String homePageUrl2 = driver.getCurrentUrl();
		if (homePageUrl2.contains("Hospital_Management_System")) {
			System.out.println("Hospital_Management_System web applications home page is displayed.");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
