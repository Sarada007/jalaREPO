package com.hms.zeomedi.smoke;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import hms.zeomedi.testyantra.genericutility.FileUtility;
import hms.zeomedi.testyantra.genericutility.WebDriverUtility;
import hms.zeomedi.testyantra.pomrepository.AdminHomePage;
import hms.zeomedi.testyantra.pomrepository.AdminLoginPage;
import hms.zeomedi.testyantra.pomrepository.HomePage;

public class LoginAndLogoutAsAdmin {
	
public static void main(String[] args) throws IOException {
	WebDriver driver;
	FileUtility fu = new FileUtility();
	WebDriverUtility wdu = new WebDriverUtility();
	
	String BROWSER = fu.readDataFromPropertyFile("browser");
	String URL = fu.readDataFromPropertyFile("url");
	
	if (BROWSER.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	} else if (BROWSER.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	} else if (BROWSER.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	} else
		driver = new ChromeDriver();
	
	HomePage hp = new HomePage(driver);
	AdminLoginPage alp = new AdminLoginPage(driver);
	AdminHomePage ahp = new AdminHomePage(driver);
	
	wdu.maximizeTheBrowser(driver);
	wdu.implicitWait(driver);
	driver.get(URL);
	
	hp.getAdminClickHereButton().click();
	alp.adminLogin(fu.readDataFromPropertyFile("admin_username"), fu.readDataFromPropertyFile("admin_password"));
	ahp.adminLogout();


	System.out.println("merge done");
	
	
}
}
