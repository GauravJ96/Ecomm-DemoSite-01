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
public class TestCase5 {
	
private WebDriver driver;
private String baseUrl = "http://live.techpanda.org/index.php/";
private By accountlink = By.linkText("ACCOUNT");
private By myAccountLink = By.linkText("My Account");
private By createAccountLink = By.linkText("CREATE AN ACCOUNT");
//new accounts user details locators
private By firstNameField = By.id("firstname");
private By lastNameField = By.id("lastname");
private By emailField = By.id("email_address");
private By password = By.id("password");
private By confirmPassword = By.id("confirmation");
private By registerButton = By.xpath("//button[@title='Register']");
//account confirmation locators
private By successMsg = By.className("success-msg");
//dashboard locators
private By tvLinkPage = By.xpath("//a[contains(.,'TV')]");
//tv page locators
private By lgLcdAddToWishList = By.xpath("(//a[@class='link-wishlist'][normalize-space()='Add to Wishlist'])[1]");
//wishlist locators
private By shareWishList = By.xpath("//span[contains(text(),'Share Wishlist')]");
private By shareEmailAdresses = By.id("email_address");
private By shareMessage = By.id("message");
private By shareWishListButton = By.xpath("//button[@title='Share Wishlist']");
private By sharedSuccessMsgLocator = By.className("success-msg");
//Successful messages 
private String registrationSuccessMsg = "Thank you for registering with Main Website Store.";
private String sharedSuccessMsg= "Your Wishlist has been shared.";
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",  "resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	
	@Test
	public void testVerifyAccountCreation() throws InterruptedException {
		// Step 1: Navigate to the website
		driver.get(baseUrl);
		
		// Step 2: Click on the account menu link
		driver.findElement(accountlink).click();
		
		// Step 3a: Click on CREATE NEW ACCOUNT button
		//Thread.sleep(1000);
		driver.findElement(myAccountLink).click();
		driver.findElement(createAccountLink).click();
		
		// Step 3b : Fill the new user details
		driver.findElement(firstNameField).sendKeys("tim");
		driver.findElement(lastNameField).sendKeys("jackson");
		driver.findElement(emailField).sendKeys("tim@jackson.com");
		driver.findElement(password).sendKeys("pwd123");
		driver.findElement(confirmPassword).sendKeys("pwd123");
		
		// Step 4: Click on the "Register" button
		driver.findElement(registerButton).click();
		
		// Step 5: Verify the Registration is done 
		String accountConfirmationMsg = driver.findElement(successMsg).getText();
		
		try {
			assertEquals(accountConfirmationMsg, registrationSuccessMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Step 6: Go to TV menu
		driver.findElement(tvLinkPage).click();
		
		// Step 7: Add product in your wishlist
		driver.findElement(lgLcdAddToWishList).click();
		
		// Step 8 : click Share Wish list
		driver.findElement(shareWishList).click();
		
		// Step 9 : In next page enter emailid and message and click on share wishlist
		driver.findElement(shareEmailAdresses).sendKeys("jerry@seinfeld.com");
		driver.findElement(shareMessage).sendKeys("Hey check this out!");
		driver.findElement(shareWishListButton).click();
		// Step 10 : Check wish list is shared
		String sharedWishListSuccessMsg = driver.findElement(sharedSuccessMsgLocator).getText();
		
		try {
			assertEquals(sharedWishListSuccessMsg, sharedSuccessMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}









