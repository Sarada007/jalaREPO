package hms.zeomedi.testyantra.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to perform all WebDriver related operations.
 * @author Piyush
 */
public class WebDriverUtility {
	/**
	 * This method is used to maximize the browser.
	 * @author Piyush
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimize the browser.
	 * @author Piyush
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to provide implicit wait.
	 * 
	 * @author Piyush
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitWaitDuration));
	}

	public void explicitWaitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void explicitWaitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void explicitWaitForTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void explicitWaitForURLContains(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}

	public void explicitWaitForAlertPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void NoSuchElementException(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.explicitlyWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}

	public void selectElementInDropdownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectElementInDropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectElementInDropdownByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void getElementsInDropdown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allOptions = select.getOptions();
		for (WebElement option : allOptions) {
			String optionText = option.getText();
			System.out.println(optionText);
		}
	}

	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement destElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(srcElement, destElement).perform();
	}

	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public void scrollingAction(WebDriver driver, WebElement element , int xOffset , int yOffset) {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(xOffset,yOffset).perform();
	}

	public void handleFrameByID(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	public void handleFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void handleFrameByElementAddress(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void FrameToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void NestedToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void HandleAlertPopupAccept(WebDriver driver, String alertText) {
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equalsIgnoreCase(alertText)) {
			System.out.println("Desired alert is present");
		} else {
			System.out.println("Desired alert is not present");
		}
		alert.accept();
	}

	public void HandleAlertPopupDismiss(WebDriver driver, String alertText) {
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equalsIgnoreCase(alertText)) {
			System.out.println("Desired alert is present");
		} else {
			System.out.println("Desired alert is not present");
		}
		alert.dismiss();
	}

	public String TakingWebPageScreenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				"./errorshots/" + screenshotName + LocalDateTime.now().toString().replace(':', '-') + ".png");
		FileUtils.copyFile(srcFile, destFile);
		return screenshotName;
	}

	public String TakingWebElementScreenshot(WebElement element, String screenshotName) throws IOException {
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				"./errorshots/" + screenshotName + LocalDateTime.now().toString().replace(':', '-') + ".png");
		FileUtils.copyFile(srcFile, destFile);
		return screenshotName;
	}

	public void switchingWindows(WebDriver driver, String title) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String wId : allWindowIds) {
			driver.switchTo().window(wId);
			if (driver.getTitle().contains(title)) {
				break;
			}
		}
	}

	public void switchingWindows(String url, WebDriver driver) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String wId : allWindowIds) {
			driver.switchTo().window(wId);
			if (driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}

	public void fluentWait(WebDriver driver, long pollingTime , WebElement element) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(Constants.explicitlyWaitDuration));
		fluentWait.pollingEvery(Duration.ofMillis(pollingTime));
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
		fluentWait.ignoring(NoSuchElementException.class);
	}

	public void customWait(int duration, WebElement element, long pollingTime) {
		int count = 0;
		while (count < duration) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (Exception e2) {

				}
			}
			count++;
		}
	}
}
