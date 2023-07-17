package hms.zeomedi.testyantra.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRegistrationPage {
	//WebDriver driver;

	public PatientRegistrationPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "full_name")
	private WebElement fullName;

	public WebElement getFullName() {
		return fullName;
	}

	@FindBy(name = "address")
	private WebElement address;

	public WebElement getAddress() {
		return address;
	}

	@FindBy(name = "city")
	private WebElement city;

	public WebElement getCity() {
		return city;
	}

	@FindBy(css = "label[for='rg-female']")
	private WebElement genderFemale;

	public WebElement getGenderFemale() {
		return genderFemale;
	}

	@FindBy(css = "label[for='rg-male']")
	private WebElement genderMale;

	public WebElement getGenderMale() {
		return genderMale;
	}

	@FindBy(id = "email")
	private WebElement email;

	public WebElement getEmail() {
		return email;
	}

	@FindBy(id = "password")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(id = "password_again")
	private WebElement passwordAgain;

	public WebElement getPasswordAgain() {
		return passwordAgain;
	}

	@FindBy(xpath = "label[for='agree']")
	private WebElement iAgreeCheckBox;

	public WebElement getIAgreeCheckBox() {
		return iAgreeCheckBox;
	}

	@FindBy(xpath = "//a[contains(text(),'Log-in')]")
	private WebElement loginLink;

	public WebElement getLoginLink() {
		return loginLink;
	}

	@FindBy(id = "submit")
	private WebElement submitButton;

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void patientRegistration(String patientFullName, String patientAddress, String patientCity,
			String patientGender, String patientMail, String patientPassword) {
		fullName.sendKeys(patientFullName);
		address.sendKeys(patientAddress);
		city.sendKeys(patientCity);
		if (patientGender.equalsIgnoreCase("Male")) {
			genderMale.click();
		} else {
			genderFemale.click();
		}
		email.sendKeys(patientMail);
		password.sendKeys(patientPassword);
		passwordAgain.sendKeys(patientPassword);
		if (iAgreeCheckBox.isSelected()) {

		} else {
			iAgreeCheckBox.click();
		}
		submitButton.click();
	}
}
