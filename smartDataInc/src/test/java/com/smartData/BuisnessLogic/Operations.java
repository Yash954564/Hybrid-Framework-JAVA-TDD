package com.smartData.BuisnessLogic;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Operations {

	public static WebDriver driver;
	
	public void openURL() {
		try {
			PropertiesFileReader reader = new PropertiesFileReader(System.getProperty("user.dir") + "//Properties//config.properties");
//	        String browser = reader.getProperty("browser");
	        String url = reader.getProperty("url");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/ChromeDriver");
			WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--zoom=40%");
//	        options.addArguments("-incognito");
//	        options.addArguments("headless");
	        driver = new ChromeDriver(options);
	        driver.get(url);		
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void closeURL() {
		driver.quit();
	}
	
	public void sendkey(String XPATHS, String KEYS, String STEP) throws IOException {
		try {
			WAITING(XPATHS);
			driver.findElement(By.xpath(XPATHS)).sendKeys(KEYS);
			HTMLReportGenerator.test.log(LogStatus.PASS," "+STEP+" "+HTMLReportGenerator.test.addScreenCapture(HTMLReportGenerator.capture(STEP))+"");
		} catch (Exception e) {
			HTMLReportGenerator.test.log(LogStatus.FAIL," "+STEP+" "+HTMLReportGenerator.test.addScreenCapture(HTMLReportGenerator.capture(STEP))+"");
		}
	    
	}
	
	public void click(String XPATHS) {
		WAITING(XPATHS);
		driver.findElement(By.xpath(XPATHS)).click();
	}
	
	public void submit(String XPATHS) {
		WAITING(XPATHS);
		driver.findElement(By.xpath(XPATHS)).submit();;
	}
	
	public void WAITING(String PATHS) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PATHS)));
	}
	
	public void verifyTitle(String TPATHS, String actual) {
		WAITING(TPATHS);
	    String expected = driver.findElement(By.xpath(TPATHS)).getText();
	    Assert.assertEquals(actual, expected);
	    if (!expected.equals(actual)) {
	        throw new AssertionError("Expected title: \"" + actual + "\" but found: \"" + expected + "\"\nXPath: " + TPATHS);
	    }
	}
	
//	public void Attachment(String XPATHS) {
//		String desc = System.getProperty("user.dir");
//		System.out.println(desc);
//		String ImageURL = desc+"\\Attachments\\Capture.PNG";
//		sendkey(XPATHS, ImageURL);
//	}
	
	public void ScrollBY(int pxn) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+pxn+")", "");
	}
	
	public void UploadFile(String fileInput, String filePath) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", fileInput, filePath);

	}
	

	
	
}
