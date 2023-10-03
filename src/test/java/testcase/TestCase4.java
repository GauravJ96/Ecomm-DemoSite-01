package testcase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
public class TestCase4 {
	
private WebDriver driver;
private String baseUrl = "http://live.techpanda.org/index.php/";
private By mobileMenuLink = By.linkText("MOBILE");
private By sonyAddtoCompare = By.xpath("(//a[@class='link-compare'][normalize-space()='Add to Compare'])[1]");
private By iPhoneAddToCompare = By.xpath("(//a[@class='link-compare'][normalize-space()='Add to Compare'])[2]");
private By compareBtn = By.xpath("//span[text()='Compare']");
private String popupHeading = "COMPARE PRODUCTS";
private By headingText = By.tagName("h1");
private By mainMobile1Text = By.xpath("//a[@title='Sony Xperia']");
private By mainMobile2Text = By.xpath("//h2/a[@title='IPhone']");
private By popUpMobile1 = By.xpath("//a[.='Sony Xperia']");
private By popUpMobile2 = By.xpath("//a[.='IPhone']");
private By closeWindowBtn = By.xpath("//button[@title='Close Window']");
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",  "resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	
	@Test
	public void testVerifyPopupContent() throws InterruptedException {
		// Step 1: Navigate to the website
		driver.get(baseUrl);
		
		// Step 2: Click on the mobile menu link
		driver.findElement(mobileMenuLink).click();
		
		// Step 3: Click on "Add to Compare" for two mobiles
		driver.findElement(sonyAddtoCompare).click();
		String mainPageMobile1 = driver.findElement(mainMobile1Text).getText();
		
		driver.findElement(iPhoneAddToCompare).click();
		String mainPageMobile2 = driver.findElement(mainMobile2Text).getText();
		
		// Step 4: Click on the "Compare" button
		driver.findElement(compareBtn).click();
		Thread.sleep(1000);
		//switching to pop up window
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// Step 5: Verify the popup content
		//checking heading compare products
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String actualHeading = driver.findElement(headingText).getText();
		
		
		String actualTextOfMobile1 = driver.findElement(popUpMobile1).getText();
		String actualTextOfMobile2 = driver.findElement(popUpMobile2).getText();
		
		System.out.println("popUpMobile1 "+actualTextOfMobile1);
		System.out.println("popUpMobile2 "+actualTextOfMobile2);
		Thread.sleep(1000);
		//to check the heading
		try {
			assertEquals(actualHeading, popupHeading);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//check mobile 1
		try {
			assertEquals(actualTextOfMobile1, mainPageMobile1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//check mobile 2
		try {
			assertEquals(actualTextOfMobile2, mainPageMobile2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//close pop up window
		driver.findElement(closeWindowBtn).click();
		
		//switching to new window
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}









