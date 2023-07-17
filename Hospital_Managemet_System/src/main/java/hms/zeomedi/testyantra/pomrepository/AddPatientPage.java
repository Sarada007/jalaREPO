package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage {
	public AddPatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "patname") private WebElement patientName;
	
	@FindBy(name = "patcontact") private WebElement patientContact;
	
	@FindBy(name = "patemail") private WebElement patientMail;
	
	@FindBy(xpath = "//label[@for='rg-male']") private WebElement maleRadioButton;
	
	@FindBy(xpath = "//label[@for='rg-female']") private WebElement femaleRadioButton;
	
	@FindBy(name = "pataddress") private WebElement patientAddress;
	
	@FindBy(name = "patage") private WebElement patientAge;
	
	@FindBy(name = "medhis") private WebElement patientMedicalHistory;
	
	@FindBy(name = "submit") private WebElement submitButton;

	public WebElement getPatientName() {
		return patientName;
	}

	public WebElement getPatientContact() {
		return patientContact;
	}

	public WebElement getPatientMail() {
		return patientMail;
	}

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getPatientAddress() {
		return patientAddress;
	}

	public WebElement getPatientAge() {
		return patientAge;
	}

	public WebElement getPatientMedicalHistory() {
		return patientMedicalHistory;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void addingPatientDetails(String name , String contact , String mail , String gender , String address , String age , String medicalHistory) {
		patientName.sendKeys(name);
		patientContact.sendKeys(contact);
		patientMail.sendKeys(mail);
		if (gender.equalsIgnoreCase("Male")) {
			maleRadioButton.click();
		} else {
			femaleRadioButton.click();
		}
		patientAddress.sendKeys(address);
		patientAge.sendKeys(age);
		patientMedicalHistory.sendKeys(medicalHistory);
		submitButton.click();
	}
}
