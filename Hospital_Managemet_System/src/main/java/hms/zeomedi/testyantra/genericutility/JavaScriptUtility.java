package hms.zeomedi.testyantra.genericutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	JavascriptExecutor jse;
	
	public JavaScriptUtility(WebDriver driver) {
		jse = (JavascriptExecutor)driver;
	}
	
	public void scrollUp() {
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	public void scrollTillElement(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView", element);
	}
	
	public void scrollDown() {
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void launchApplication(String url) {
		jse.executeScript("window.location=arguments[0]", url);
	}
	
	public void sendKeys(WebElement element , String data) {
		jse.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	
	public void click(WebElement element) {
		jse.executeScript("arguments[0].click()", element);
	}
	
	public void clickElementById(String elementId) {
		jse.executeScript("document.getElementById('elementId').click()");
	}
	
	public String getTheText(WebElement element) {
		String textFieldValue = (String) jse.executeScript("return argument[0].value", element);
		return textFieldValue;
	}
	
	public String getUrlOfCurrentPage() {
		String url = (String) jse.executeScript("return window.location.href");
		return url;
	}
	
	public String getTitleOfCurrentPage() {
		String title = (String) jse.executeScript("return document.title");
		return title;
	}
}
