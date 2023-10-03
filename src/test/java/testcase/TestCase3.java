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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
public class TestCase3 {
	
private WebDriver driver;
private String baseUrl = "http://live.techpanda.org/index.php/";
private By mobile = By.linkText("MOBILE");
private By addSonyToCart = By.xpath("//button[@class='button btn-cart'][1]");
private By quantity = By.xpath("//input[@title='Qty']");
private By updateBtn = By.xpath("//button[@title='Update']");
private By errorMessage = By.className("item-msg");
private By emptyCart = By.id("empty_cart_button");
private By EmptyCartMsg = By.tagName("h1");
private String expectedErrorMsg = "* The maximum quantity allowed for purchase is 500.";
private String expectedEmptyCartMsg = "SHOPPING CART IS EMPTY";
	@BeforeTest
	public void startUp() {
		System.setProperty("webdriver.chrome.driver",  "resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	
	@Test
	public void testDay3TestCase3() {
		//step1 go to the http://live.techpanda.org
		driver.get(baseUrl);
		
		//step2 click on mobile menu
		driver.findElement(mobile).click();
		
		//step3 click on add to cart on sony experia mobile
		driver.findElement(addSonyToCart).click();

		//step4 change qty value to 1000 and click on update btn
		driver.findElement(quantity).sendKeys("1000");
		driver.findElement(updateBtn).click();
		
		//step5 verify the error msg
		String actualErrorMsg = driver.findElement(errorMessage).getText();
		assertEquals(actualErrorMsg, expectedErrorMsg);
		
		//step6 click on empty cart link
		driver.findElement(emptyCart).click();
		
		//step7 verify cart is empty
		String actualEmptyCartMsg = driver.findElement(EmptyCartMsg).getText();
		assertEquals(actualEmptyCartMsg, expectedEmptyCartMsg);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}









